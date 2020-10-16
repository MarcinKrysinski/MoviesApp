package pl.krysinski.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krysinski.movies.component.PostAspect;
import pl.krysinski.movies.model.Movie;
import pl.krysinski.movies.service.MovieService;

import java.util.List;

//@RestController
//@RequestMapping(value = "/movies", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        return new ResponseEntity<>(movieService.getAllMoviesList(), HttpStatus.OK);
    }

    @PostAspect
    @PostMapping
    public ResponseEntity addMovie(@RequestBody Movie movie){
        boolean addMovie = movieService.addMovie(movie);
        if (addMovie){
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{movieName}")
    public ResponseEntity deleteMovieByName(@PathVariable String movieName){
        boolean deleteMovieByName = movieService.deleteMovie(movieName);
        if (deleteMovieByName){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
