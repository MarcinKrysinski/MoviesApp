package pl.krysinski.movies.service;

import pl.krysinski.movies.model.Movie;

import java.util.List;

public interface MovieService {
    
    List<Movie> getAllMoviesList();
    boolean addMovie(Movie movie);
    boolean deleteMovie(String movieName);
    
    
}
