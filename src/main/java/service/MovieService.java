package service;

import model.Movie;
import model.MovieInfo;
import model.MovieResponse;
import model.Trailer;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();
//    MovieResponse getDummyMovie(int skip , int limit);
    MovieResponse getDummyMovie(String movieName, int page);

    String getTrailer(int id);
    MovieInfo getMovieDetail(int id);
}
