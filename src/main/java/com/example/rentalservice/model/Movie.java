package com.example.rentalservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Movie data")
public class Movie {
    @ApiModelProperty("unique ID of movie")
    private Long MovieID;
    private String name;
    private Category category;


    public Movie() {
    }

    public Movie(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Movie(Long MovieID, String name, Category category) {
        this.MovieID = MovieID;
        this.name = name;
        this.category = category;
    }

    public Long getMovieID() {
        return MovieID;
    }

    public void setMovieID(Long id) {
        this.MovieID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
