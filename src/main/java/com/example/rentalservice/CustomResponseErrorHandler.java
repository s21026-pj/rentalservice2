package com.example.rentalservice;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Scanner;

public class CustomResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        HttpStatus status = clientHttpResponse.getStatusCode();
        return status.is4xxClientError() || status.is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        HttpStatus status = clientHttpResponse.getStatusCode();
        switch (status){
            case NOT_FOUND:
                throw new NotFoundException();
            case BAD_REQUEST:
                throw new BadRequestException();
            case INTERNAL_SERVER_ERROR:
                throw new BadGatewayException();
            default:
                throw new ForbiddenException();
        }
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse clientHttpResponse) throws IOException {
        HttpStatus status = clientHttpResponse.getStatusCode();
        switch (status){
            case NOT_FOUND:
                throw new NotFoundException();
            case BAD_REQUEST:
                throw new BadRequestException();
            case INTERNAL_SERVER_ERROR:
                throw new BadGatewayException();
            default:
                throw new ForbiddenException();
        }
    }



    @ResponseStatus(HttpStatus.NOT_FOUND)
    static class NotFoundException extends IOException { }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    static class BadRequestException extends IOException { }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    static class BadGatewayException extends IOException { }

    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    static class ForbiddenException extends IOException { }

    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
    static class GatewayException extends RuntimeException { }
    }
