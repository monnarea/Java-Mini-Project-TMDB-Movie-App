import model.Movie;
import model.MovieResponse;
import service.MovieService;
import service.MovieServiceImpl;
import utils.TableRenderer;

import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static final MovieService service = new MovieServiceImpl();
    private static int pageSize = 20;
    private static int pageNumber = 1;
//    private static int totalPage = (service.getAll().size() + pageSize -1 ) / pageSize;
    private static int totalPage = 2;
    private static int skip = (pageNumber - 1) * pageSize;

    private static void updatePageNumber(int pageNum){
        if (pageNum < 1){
            pageNumber = 1 ;
            return;
        }
        if (pageNum > totalPage){
            pageNumber = totalPage;
            return;
        }
        pageNumber = pageNum;
        skip =  (pageNumber - 1) * pageSize;
    }
    static void main() {
//        List<Movie> movies = service.getAll();

        System.out.printf("Page %d / %d", pageNumber, totalPage);
        while (true){
            MovieResponse response = service.getDummyMovie(skip,pageSize);
            TableRenderer.displayTableProduct(response);
            System.out.println("""
                    [n]  Next Page
                    [p]  Previous Page
                    [gt] Got To Page
                    [e]  Exit
                    """);
            System.out.print("Choose option: ");
            String op = scanner.next();

            switch (op.toLowerCase()){
                case "n" -> {
                    updatePageNumber(pageNumber + 1);
                }
                case "p" -> {
                    updatePageNumber(pageNumber - 1);
                }
                case "gt" -> {
                    System.out.print("[!] Enter page number: ");
                    int page = scanner.nextInt();
                    updatePageNumber(page);

                }
                case "e" -> System.exit(0);
            }
        }
    }
}
