package com.company;

import com.google.gson.Gson;

import javax.imageio.IIOException;
import javax.swing.*;
import java.io.*;
import java.util.List;

public class JsonReader {
    private static Gson gson = new Gson();

    public static List<Movie> getMovies() throws IOException {
        try(Reader reader = new FileReader("movies.json")){
            List<Movie> movies = List.of(gson.fromJson(reader, Movie[].class));
            return movies;
        }
    }

    public static void writeMovies(List<Movie> movies)throws IOException{
        try(Writer writer = new FileWriter("movies.json")){
            String json = gson.toJson(movies);
            writer.write(json);
        }
    }
}
