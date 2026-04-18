package utils;

import model.*;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import service.MovieService;
import service.MovieServiceImpl;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TableRenderer {
    public static void displayTableMovie(MovieResponse response ){
        Table table = new Table(
                5,
                BorderStyle.CLASSIC,
                ShownBorders.ALL
        );
        CellStyle center = new CellStyle(CellStyle.HorizontalAlign.CENTER);

        if (response == null || response.getMovies() == null) {
            System.out.println("No movies found to display.");
            return;
        }
        String[] columns = {"ID", "Title", "Release", "Rating", "Trailer"};
        for (String column : columns){
            table.addCell(column , center);
        }

        MovieService movieService = new MovieServiceImpl();
//        List<Movie> partialData = movies
//                        .stream().skip(skip).limit(limit).toList();
        for (Movie movie : response.getMovies()){
            table.addCell(movie.getId().toString());
            table.addCell(movie.getOriginalTitle());
            table.addCell(movie.getReleaseDate() != null ? movie.getReleaseDate() : "N/A");
//            table.addCell(movie.getCategory());
            table.addCell(movie.getVoteAverage().toString());
            String trailerUrl = movieService.getTrailer(movie.getId());

            table.addCell(trailerUrl);
        }
        System.out.println(table.render());
        System.out.printf("Page %d / %d  | ", response.getPage() , response.getTotalPages());
        System.out.println("Total Results: "+ response.getTotalResults());
    }
    public static void displayTableMovieInformation(MovieInfo info) {
        if (info == null) {
            System.out.println("No movies found to display.");
            return;
        }
        Table table = new Table(2, BorderStyle.CLASSIC);

        table.addCell("MOVIE INFORMATION", 2);
        table.addCell("Title");
        table.addCell(info.getTitle() != null ? info.getTitle() : "N/A");
        table.addCell("Release");
        table.addCell(info.getReleaseDate() != null ? info.getReleaseDate() : "N/A");
        table.addCell("Rating");
        table.addCell(info.getVoteAverage() != null ? info.getVoteAverage() + " / 10" : "N/A");
        table.addCell("Runtime");
        table.addCell(info.getRuntime() != null ? info.getRuntime() + " min" : "N/A");
        table.addCell("Budget");
        table.addCell(info.getBudget() != null ? String.format("$%,.0f", info.getBudget()) : "N/A");
        table.addCell("Genres");
        String genreNames = info.getGenres() != null
                ? Arrays.stream(info.getGenres())
                .map(Genres::getName)
                .collect(Collectors.joining(", "))
                : "N/A";
        table.addCell(genreNames);
        table.addCell("Origin");
        table.addCell(info.getOriginalCountry() != null
                ? String.join(", ", info.getOriginalCountry()) : "N/A");

        System.out.println(table.render());
    }
}
