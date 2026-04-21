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
    public static final String green = "\u001B[32m";
    public static final String blue = "\u001B[34m";
    public static final String yellow = "\u001B[33m";
    public static final String purple = "\u001B[35m";
    public static final String red = "\u001B[31m";
    public static final String cyan = "\u001B[36m";
    public static final String white = "\u001B[37m";

    public static void displayTableMovie(MovieResponse response ){
        Table table = new Table(
                5,
                BorderStyle.CLASSIC,
                ShownBorders.ALL
        );
        CellStyle center = new CellStyle(CellStyle.HorizontalAlign.CENTER);

        if (response == null || response.getResults() == null) {
            System.out.println(yellow+"No movies found to display.");
            return;
        }
        String[] columns = {green+"ID", yellow+"Title", purple+"Release",blue+ "Rating", cyan+"Trailer"};
        for (String column : columns){
            table.addCell(column , center);
        }

        MovieService movieService = new MovieServiceImpl();
        for (Movie movie : response.getResults()){
            table.addCell(green+movie.getId().toString());
            table.addCell(yellow+movie.getOriginalTitle());
            table.addCell(purple+movie.getReleaseDate() != null ? purple+movie.getReleaseDate() : "N/A");
            table.addCell(blue+movie.getVoteAverage().toString());
            String trailerUrl = movieService.getTrailer(movie.getId());

            table.addCell(cyan+trailerUrl);
        }
        System.out.println(table.render());
        System.out.printf(green+"Page %d / %d  | ", response.getPage() , response.getTotalPages());
        System.out.println(green+"Total Results: "+ response.getTotalResults());
    }
    public static void displayTableMovieInformation(MovieInfo info) {
        if (info == null) {
            System.out.println("No movies found to display.");
            return;
        }

        Table table = new Table(2, BorderStyle.CLASSIC);

        table.addCell("MOVIE INFORMATION", 2);
        table.addCell(blue+"Title");
        table.addCell(info.getTitle() != null ? info.getTitle() : "N/A");
        table.addCell(yellow+"Release");
        table.addCell(info.getReleaseDate() != null ? info.getReleaseDate() : "N/A");
        table.addCell(green+"Rating");
        table.addCell(info.getVoteAverage() != null ? info.getVoteAverage() + " / 10" : "N/A");
        table.addCell(cyan+"Runtime");
        table.addCell(info.getRuntime() != null ? info.getRuntime() + " min" : "N/A");
        table.addCell(purple+"Budget");
        table.addCell(info.getBudget() != null ? String.format("$%,.0f", info.getBudget()) : "N/A");
        table.addCell(red+"Genres");
        String genreNames = info.getGenres() != null
                ? Arrays.stream(info.getGenres())
                .map(Genres::getName)
                .collect(Collectors.joining(", "))
                : "N/A";
        table.addCell(genreNames);
        table.addCell(blue+"Origin");
        table.addCell(info.getOriginalCountry() != null
                ? String.join(", ", info.getOriginalCountry()) : "N/A");

        System.out.println(table.render());
    }
}
