package com.company;

import com.google.gson.Gson;

import javax.imageio.IIOException;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;

public class JsonReader {
    private static Gson gson = new Gson();

    public static ArrayList<Movie> getMovies() throws IOException {
        try(Reader reader = new FileReader("movies.json")){
            Movie[] movies = gson.fromJson(reader, Movie[].class);
            ArrayList<Movie> movie = new ArrayList<>();
            for (Movie m: movies){
                movie.add(m);
            }
            return movie;
        }
    }
    public static ArrayList<Cast> getCast() throws IOException {
        try(Reader reader = new FileReader("movies.json")){
            Cast[] cast = gson.fromJson(reader, Cast[].class);
            ArrayList<Cast> casts = new ArrayList<>();
            for (Cast c: cast){
                casts.add(c);
            }
            return casts;
        }
    }

    public static void writeMovies(List<Movie> movies)throws IOException{
        try(Writer writer = new FileWriter("movies.json")){
            String json = gson.toJson(movies);
            writer.write(json);
        }
    }
}
