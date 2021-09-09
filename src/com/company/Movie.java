package com.company;

public class Movie {
    private String name;
    private Integer year;
    private String Description;
    private Director director;
    private Cast[] cast;

    public Movie(String name, Integer year, String description, Director director, Cast[] cast) {
        this.name = name;
        this.year = year;
        Description = description;
        this.director = director;
        this.cast = cast;
    }

    public Cast[] getCast() {
        return cast;
    }

    public void setCast(Cast[] cast) {
        this.cast = cast;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}