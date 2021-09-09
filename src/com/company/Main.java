package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)throws IOException {
        List<Movie> movies =  JsonReader.getMovies();
        for(Movie m: movies){
            System.out.println(m.getName());
        }



    }
}
