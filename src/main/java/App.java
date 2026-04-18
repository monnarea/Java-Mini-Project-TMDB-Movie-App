import model.MovieInfo;
import model.MovieResponse;
import service.MovieService;
import service.MovieServiceImpl;
import utils.TableRenderer;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static final MovieService service = new MovieServiceImpl();
//    private static int pageSize = 20;
//    private static int pageNumber = 1;
////    private static int totalPage = (service.getAll().size() + pageSize -1 ) / pageSize;
//    private static int totalPage = 2;
//    private static int skip = (pageNumber - 1) * pageSize;

    private static void updatePageNumber(int pageNum ,int pageNumber, int totalPage){
        if (pageNum < 1){
            pageNumber = 1 ;
            return;
        }
        if (pageNum > totalPage){
            pageNumber = totalPage;
            return;
        }
        pageNumber = pageNum;
//        skip =  (pageNumber - 1) * pageSize;
    }
    private static void popularMovie(){
        sideMenu:
        while (true){
            int p = 1;
            MovieResponse popularMovie = service.getPopularMovie(p);
            TableRenderer.displayTableMovie(popularMovie);

//            System.out.printf("Page %d / %d", pageNumber, totalPage);
            System.out.println("""
                    [n]  Next Page
                    [p]  Previous Page
                    [gt] Got To Page
                    [md] Movie Detail
                    [b]  Back to Main menu
                    [e]  Exit
                    """);
            System.out.print("Choose option: ");
            String op = scanner.next();
            switch (op.toLowerCase()){
                case "n" -> {

                    if ( p == popularMovie.getTotalPages()){
                        p = popularMovie.getTotalPages();
                    }else {
                        p += 1;
                    }
                    TableRenderer.displayTableMovie(popularMovie);
                }
                case "p" -> {
                    if (p == 1){
                        p = 1;
                    }else {
                        p -= 1;
                    }
                }
                case "gt" -> {
                    boolean validInput = false;
                    while (!validInput){
                        System.out.print("[!] Enter page number: ");
                        int page = scanner.nextInt();
                        if (page > popularMovie.getTotalPages()){
                            System.out.println("There are only "+popularMovie.getTotalPages()+" pages ! Please Enter another number");
                        } else if (page <= 0) {
                            System.out.println("Please Enter another page that greater that 0 !");
                        }else {
                            p = page;
                            validInput = true;
                        }
                    }

                }
                case "md" -> {
                    System.out.print("[!] Enter Movie Id: ");
                    int id = scanner.nextInt();
                    MovieInfo movieInfo = service.getMovieDetail(id);
                    TableRenderer.displayTableMovieInformation(movieInfo);
                }
                case "b" -> {
                    break sideMenu;
                }
                case "e" -> System.exit(0);
            }
        }

    }

    public static void main(String[] args) {
//        List<Movie> movies = service.getAll();

        while (true){

            System.out.println("""
                    ███╗   ███╗ ██████╗ ██╗   ██╗██╗███████╗    ███████╗███████╗ █████╗ ██████╗  ██████╗██╗  ██╗
                    ████╗ ████║██╔═══██╗██║   ██║██║██╔════╝    ██╔════╝██╔════╝██╔══██╗██╔══██╗██╔════╝██║  ██║
                    ██╔████╔██║██║   ██║██║   ██║██║█████╗      ███████╗█████╗  ███████║██████╔╝██║     ███████║
                    ██║╚██╔╝██║██║   ██║╚██╗ ██╔╝██║██╔══╝      ╚════██║██╔══╝  ██╔══██║██╔══██╗██║     ██╔══██║
                    ██║ ╚═╝ ██║╚██████╔╝ ╚████╔╝ ██║███████╗    ███████║███████╗██║  ██║██║  ██║╚██████╗██║  ██║
                    ╚═╝     ╚═╝ ╚═════╝   ╚═══╝  ╚═╝╚══════╝    ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝
                    
                    """);
            System.out.print("Enter Movie Name: ");
            String name = scanner.next();
            int p = 1;

            menu:
            while (true){

                MovieResponse response = service.getDummyMovie(
                        name , p
                );
                TableRenderer.displayTableMovie(response);
//            System.out.printf("Page %d / %d", pageNumber, totalPage);
                System.out.println("""
                    [n]  Next Page
                    [p]  Previous Page
                    [gt] Got To Page
                    [md] Movie Detail
                    [gp] View Popular Movie
                    [b]  Back
                    [e]  Exit
                    """);
                System.out.print("Choose option: ");
                String op = scanner.next();

                switch (op.toLowerCase()){
                    case "n" -> {

                        if ( p == response.getTotalPages()){
                            p = response.getTotalPages();
                        }else {
                            p += 1;
                        }

                    }
                    case "p" -> {
                        if (p == 1){
                            p = 1;
                        }else {
                            p -= 1;
                        }
                    }
                    case "gt" -> {
                        boolean validInput = false;
                        while (!validInput){
                            System.out.print("[!] Enter page number: ");
                            int page = scanner.nextInt();
                            if (page > response.getTotalPages()){
                                System.out.println("There are only "+response.getTotalPages()+" pages ! Please Enter another number");
                            } else if (page <= 0) {
                                System.out.println("Please Enter another page that greater that 0 !");
                            }else {
                                p = page;
                                validInput = true;
                            }
                        }

                    }
                    case "md" -> {
                        System.out.print("[!] Enter Movie Id: ");
                        int id = scanner.nextInt();
                        MovieInfo movieInfo = service.getMovieDetail(id);
                        TableRenderer.displayTableMovieInformation(movieInfo);
                    }
                    case "gp" -> {
                        popularMovie();
                    }
                    case "b" -> {
                        break menu;
                    }
                    case "e" -> System.exit(0);
                }
            }

        }
    }
}
