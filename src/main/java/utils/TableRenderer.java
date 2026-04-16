package utils;

import model.Movie;
import model.MovieResponse;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;

public class TableRenderer {
    public static void displayTableProduct(MovieResponse response){
        Table table = new Table(
                5,
                BorderStyle.CLASSIC,
                ShownBorders.ALL
        );
        CellStyle center = new CellStyle(CellStyle.HorizontalAlign.CENTER);

        String[] columns = {"ID", "Title", "Release", "Rating", "Trailer"};
        for (String column : columns){
            table.addCell(column , center);
        }

//        List<Movie> partialData = movies
//                        .stream().skip(skip).limit(limit).toList();

        for (Movie movie : response.getMovies()){
            table.addCell(movie.getId().toString());
            table.addCell(movie.getTitle());
//            table.addCell(movie.getRelease().toString());
            table.addCell(movie.getCategory());
            table.addCell(movie.getRating().toString());
//            table.addCell(movie.getTrailer());
            table.addCell(movie.getPrice().toString());
        }
        System.out.println(table.render());
    }
}
