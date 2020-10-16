package pl.krysinski.movies.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.krysinski.movies.controller.MovieController;
import pl.krysinski.movies.model.Movie;
import pl.krysinski.movies.service.MovieService;
import pl.krysinski.movies.service.MovieServiceImpl;


import java.util.Collection;

@Route("movies")
public class MovieAppGui extends VerticalLayout {
    
    private MovieServiceImpl movieService;
    
    @Autowired
    public MovieAppGui(MovieServiceImpl movieService){
        this.movieService = movieService;
        getMovies();
        addMovieFields();
    }
    Grid<Movie> grid = new Grid<>(Movie.class);
    public void getMovies(){


        grid.setItems(movieService.getAllMoviesList());


        grid.setColumns("movieName", "yearProduction", "director");
        add(grid);

    }

    public void addMovieFields(){
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        TextField movieName = new TextField("Movie name");
        TextField yearProduction = new TextField("Year production");
        TextField director = new TextField("Director");
        horizontalLayout.add(movieName, yearProduction, director);
        add(horizontalLayout);

        Button addButton = new Button("Add");
        addButton.addClickListener(event -> {
            Movie movie = new Movie(movieName.getValue(), yearProduction.getValue(), director.getValue());
            movieService.addMovie(movie);
            grid.getDataProvider().refreshAll();

        });
        add(addButton);
    }


}
