package pl.krysinski.movies.model;

public class Movie {

    String movieName;
    String yearProduction;
    String director;

    public Movie() {
    }

    public Movie(String movieName, String yearProduction, String director) {
        this.movieName = movieName;
        this.yearProduction = yearProduction;
        this.director = director;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getYearProduction() {
        return yearProduction.toString();
    }

    public void setYearProduction(String yearProduction) {
        this.yearProduction = yearProduction;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", yearProduction=" + yearProduction +
                ", director='" + director + '\'' +
                '}';
    }
}
