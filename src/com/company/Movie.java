package com.company;

import java.util.List;

public class Movie  {
    private String name;
    private Integer year;
    private String Description;
    private Director director;
    private List<Cast> cast;

    public Movie(String name, Integer year, String description, Director director, List<Cast> cast) {
        this.name = name;
        this.year = year;
        Description = description;
        this.director = director;
        this.cast = cast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Director getDirector() {
        return director;
    }

    public String getDirectorName() {
        return director.getFullName();
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Cast> getCast() {
        return cast;
    }
    public  String getCastName() {
        for (Cast c:cast
             ) {
            return c.getFullName();
        }
         return null;
    }
    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

}