package pl.krysinski.movies.service;

import org.springframework.stereotype.Service;
import pl.krysinski.movies.component.PostAspect;
import pl.krysinski.movies.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private List<Movie> movieList;

    public MovieServiceImpl(){
        this.movieList = new ArrayList<>();
        movieList.add(new Movie("Alien", "1979","Ridley Scott" ));
        movieList.add(new Movie("The Thing", "1982", "John Carpenter"));
        movieList.add(new Movie("Night of the Living Dead", "1968", "George A. Romero"));
    }

    @Override
    public List<Movie> getAllMoviesList() {
        return movieList;
    }


    @PostAspect
    @Override
    public boolean addMovie(Movie movie) {
        return movieList.add(movie);
    }

    @Override
    public boolean deleteMovie(String movieName) {
        Optional<Movie> foundMovieByName = movieList.stream().filter(movie -> movie.getMovieName().equals(movieName)).findFirst();
        if (foundMovieByName.isPresent()){
            movieList.remove(foundMovieByName.get());
            return true;
        }
        return false;
    }
}
