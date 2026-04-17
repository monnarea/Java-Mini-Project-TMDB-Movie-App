package utils;

import model.Movie;
import model.MovieInfo;
import model.MovieResponse;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Arrays;

public class TableRenderer {
    public static void displayTableMovie(MovieResponse response){
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

//        List<Movie> partialData = movies
//                        .stream().skip(skip).limit(limit).toList();
        for (Movie movie : response.getMovies()){
            table.addCell(movie.getId().toString());
            table.addCell(movie.getOriginalTitle());
            table.addCell(movie.getReleaseDate());
//            table.addCell(movie.getCategory());
            table.addCell(movie.getVoteAverage().toString());
            table.addCell(movie.getMovie());
//            table.addCell(movie.getPrice().toString());
        }
        System.out.println(table.render());
        System.out.printf("Page %d / %d  | ", response.getPage() , response.getTotalPages());
        System.out.println("Total Results: "+ response.getTotalResults());
    }
    private static void displayTableMovieInformation(MovieInfo info){
        MovieInfo movieInfo = new MovieInfo();
        Table table = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
        table.addCell("MOVIE INFORMATION",2);
        table.addCell("Title");
        table.addCell(movieInfo.getName());
        table.addCell("Rating");
        table.addCell(movieInfo.getReleaseDate());
        table.addCell("Runtime");
        table.addCell(movieInfo.getVoteAverage().toString());
        table.addCell("Budget");
        table.addCell(movieInfo.getBudget().toString());
        table.addCell("Genres");
        table.addCell(Arrays.toString(movieInfo.getGenres()));
        table.addCell("Original");
        table.addCell(movieInfo.getOriginalCountry());

        table.render();

    }
}
