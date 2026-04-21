import model.MovieInfo;
import model.MovieResponse;
import service.MovieService;
import service.MovieServiceImpl;
import utils.TableRenderer;

import java.util.Scanner;

public class App {
    public static final String green = "\u001B[32m";
    public static final String blue = "\u001B[34m";
    public static final String yellow = "\u001B[33m";
    public static final String purple = "\u001B[35m";
    public static final String red = "\u001B[31m";
    public static final String cyan = "\u001B[36m";
    public static final String white = "\u001B[37m";
    private static Scanner scanner = new Scanner(System.in);
    private static final MovieService service = new MovieServiceImpl();
    private static void popularMovie(){
        int p = 1;
        sideMenu:
        while (true){

            MovieResponse popularMovie = service.getPopularMovie(p);
            TableRenderer.displayTableMovie(popularMovie);

//            System.out.printf("Page %d / %d", pageNumber, totalPage);
            System.out.println( purple+"""
                    [n]  Next Page
                    [p]  Previous Page
                    [gt] Got To Page
                    [md] Movie Detail
                    [b]  Back to Main menu
                    [e]  Exit
                    """);
            System.out.print(cyan+"Choose option: ");
            String op = scanner.next();
            switch (op.toLowerCase()){
                case "n" -> {

                    if ( p == popularMovie.getTotalPages()){
                        p = popularMovie.getTotalPages();
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
                        if (page > popularMovie.getTotalPages()){
                            System.out.println(yellow+"There are only "+popularMovie.getTotalPages()+" pages ! Please Enter another number");
                        } else if (page <= 0) {
                            System.out.println(yellow+"Please Enter another page that greater that 0 !");
                        }else {
                            p = page;
                            validInput = true;
                        }
                    }

                }
                case "md" -> {
                    System.out.print(cyan+"[!] Enter Movie Id: ");
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
    private static void topRatedMovie(){

        int p = 1;
        sideMenu:
        while (true){

            MovieResponse topRatedMovie = service.getTopRatedMovie(p);
            TableRenderer.displayTableMovie(topRatedMovie);

//            System.out.printf("Page %d / %d", pageNumber, totalPage);
            System.out.println(blue+"""
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

                    if ( p == topRatedMovie.getTotalPages()){
                        p = topRatedMovie.getTotalPages();
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
                        System.out.print(cyan+"[!] Enter page number: ");
                        int page = scanner.nextInt();
                        if (page > topRatedMovie.getTotalPages()){
                            System.out.println(yellow+"There are only "+ topRatedMovie.getTotalPages()+" pages ! Please Enter another number");
                        } else if (page <= 0) {
                            System.out.println(yellow+"Please Enter another page that greater that 0 !");
                        }else {
                            p = page;
                            validInput = true;
                        }
                    }

                }
                case "md" -> {
                    System.out.print(cyan+"[!] Enter Movie Id: ");
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
    private static void nowPlayingMovie(){

        int p = 1;
        sideMenu:
        while (true){

            MovieResponse nowPlaying = service.getNowPlaying(p);
            TableRenderer.displayTableMovie(nowPlaying);

//            System.out.printf("Page %d / %d", pageNumber, totalPage);
            System.out.println( purple+"""
                    [n]  Next Page
                    [p]  Previous Page
                    [gt] Got To Page
                    [md] Movie Detail
                    [b]  Back to Main menu
                    [e]  Exit
                    """);
            System.out.print(cyan+"Choose option: ");
            String op = scanner.next();
            switch (op.toLowerCase()){
                case "n" -> {

                    if ( p == nowPlaying.getTotalPages()){
                        p = nowPlaying.getTotalPages();
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
                        System.out.print(cyan+"[!] Enter page number: ");
                        int page = scanner.nextInt();
                        if (page > nowPlaying.getTotalPages()){
                            System.out.println(yellow+"There are only "+ nowPlaying.getTotalPages()+" pages ! Please Enter another number");
                        } else if (page <= 0) {
                            System.out.println(yellow+"Please Enter another page that greater that 0 !");
                        }else {
                            p = page;
                            validInput = true;
                        }
                    }

                }
                case "md" -> {
                    System.out.print(cyan+"[!] Enter Movie Id: ");
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
    private static void upcomingMovie(){

        int p = 1;
        sideMenu:
        while (true){

            MovieResponse upcoming = service.getUpcoming(p);
            TableRenderer.displayTableMovie(upcoming);

//            System.out.printf("Page %d / %d", pageNumber, totalPage);
            System.out.println( blue+"""
                    [n]  Next Page
                    [p]  Previous Page
                    [gt] Got To Page
                    [md] Movie Detail
                    [b]  Back to Main menu
                    [e]  Exit
                    """);
            System.out.print(cyan+"Choose option: ");
            String op = scanner.next();
            switch (op.toLowerCase()){
                case "n" -> {

                    if ( p == upcoming.getTotalPages()){
                        p = upcoming.getTotalPages();
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
                        System.out.print(cyan+"[!] Enter page number: ");
                        int page = scanner.nextInt();
                        if (page > upcoming.getTotalPages()){
                            System.out.println(yellow+"There are only "+ upcoming.getTotalPages()+" pages ! Please Enter another number");
                        } else if (page <= 0) {
                            System.out.println(yellow+"Please Enter another page that greater that 0 !");
                        }else {
                            p = page;
                            validInput = true;
                        }
                    }

                }
                case "md" -> {
                    System.out.print(cyan+"[!] Enter Movie Id: ");
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
    private static void searchmMenu(){
        System.out.print(cyan+"Enter Movie Name: ");
        String name = scanner.next();
        int p = 1;

        menu:
        while (true){

            MovieResponse response = service.getDummyMovie(
                    name , p
            );
            TableRenderer.displayTableMovie(response);
//            System.out.printf("Page %d / %d", pageNumber, totalPage);
            System.out.println(purple+"""
                    [n]  Next Page
                    [p]  Previous Page
                    [gt] Got To Page
                    [md] Movie Detail
                    [b]  Back
                    [e]  Exit
                    """);
            System.out.print(cyan+"Choose option: ");
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
                        System.out.print(cyan+"[!] Enter page number: ");
                        int page = scanner.nextInt();
                        if (page > response.getTotalPages()){
                            System.out.println(yellow+"There are only "+response.getTotalPages()+" pages ! Please Enter another number");
                        } else if (page <= 0) {
                            System.out.println(yellow+"Please Enter another page that greater that 0 !");
                        }else {
                            p = page;
                            validInput = true;
                        }
                    }

                }
                case "md" -> {
                    System.out.print(cyan+"[!] Enter Movie Id: ");
                    int id = scanner.nextInt();
                    MovieInfo movieInfo = service.getMovieDetail(id);
                    TableRenderer.displayTableMovieInformation(movieInfo);
                }
                case "b" -> {
                    break menu;
                }
                case "e" -> System.exit(0);
            }
        }

    }




    public static void main(String[] args) {
//        List<Movie> movies = service.getAll();

        while (true) {

            System.out.println(green+"""
                    ███╗   ███╗ ██████╗ ██╗   ██╗██╗███████╗    ███████╗███████╗ █████╗ ██████╗  ██████╗██╗  ██╗
                    ████╗ ████║██╔═══██╗██║   ██║██║██╔════╝    ██╔════╝██╔════╝██╔══██╗██╔══██╗██╔════╝██║  ██║
                    ██╔████╔██║██║   ██║██║   ██║██║█████╗      ███████╗█████╗  ███████║██████╔╝██║     ███████║
                    ██║╚██╔╝██║██║   ██║╚██╗ ██╔╝██║██╔══╝      ╚════██║██╔══╝  ██╔══██║██╔══██╗██║     ██╔══██║
                    ██║ ╚═╝ ██║╚██████╔╝ ╚████╔╝ ██║███████╗    ███████║███████╗██║  ██║██║  ██║╚██████╗██║  ██║
                    ╚═╝     ╚═╝ ╚═════╝   ╚═══╝  ╚═╝╚══════╝    ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝
                    
                    """);
            System.out.println(blue+"""
                    Choose Option
                    [s] Search Movie
                    [p] Get Popular Movie
                    [t] Get Top Rated Movie
                    [u] Upcoming Movie
                    [n] Now Playing Movie
                    [e] Exit.
                    """);
            System.out.print(cyan+"Enter Option: ");
            String op = scanner.next();
            switch (op.toLowerCase()) {
                case "s" -> {
                    System.out.println(purple+"=========== [[ Search Movie ]] ===========");
                    searchmMenu();
                }
                case "p" -> {
                    System.out.println(purple+"=========== [[ Popular Movie ]] ===========");
                    popularMovie();
                }
                case "t" -> {
                    System.out.println(blue+"=========== [[ Top Rated Movie ]] ===========");
                    topRatedMovie();
                }
                case "u" -> {
                    System.out.println(blue+"=========== [[ Upcoming Movie ]] ===========");
                    upcomingMovie();
                }
                case "n" -> {
                    System.out.println(purple+"=========== [[ Now Playing Movie ]] ===========");
                    nowPlayingMovie();
                }
                case "e" -> System.exit(0);
            }
        }
    }
}
