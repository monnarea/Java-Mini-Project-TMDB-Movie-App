package service;

import model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MovieServiceImpl implements MovieService{


    private static final List<Movie> movies = new ArrayList<>();

    private static final HttpClient client =
            HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
    private static ObjectMapper mapper = new ObjectMapper();
    @Override
    public List<Movie> getAll() {

        return List.of();
    }

//    @Override
//    public MovieResponse getDummyMovie(int skip , int limit) {
//        String url =
//                String.format("https://api.themoviedb.org/3/discover/movie?api_key=bc635944a4e43701982406e7cd2dbda6",skip,limit);
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .GET()
//                .build();
//        try{
//            HttpResponse<String> response = client.send(
//                    request, HttpResponse.BodyHandlers.ofString()
//            );
//            System.out.println("Status Code" + response.statusCode());
//            System.out.println("Status " + response.body());
//            return mapper.readValue(response.body(), MovieResponse.class);
//        }catch (IOException | InterruptedException e){
//            throw new RuntimeException(e);
//        }
//
//    }
    @Override
    public String getTrailer(int id) {
        String url = String.format("https://api.themoviedb.org/3/movie/%d/videos?api_key=bc635944a4e43701982406e7cd2dbda6", id);
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiYzYzNTk0NGE0ZTQzNzAxOTgyNDA2ZTdjZDJkYmRhNiIsIm5iZiI6MTc3NjI2MDc4Ny4wNzcsInN1YiI6IjY5ZGY5NmIzMmExNjA0YzI1OWI0Y2I2MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ZNRiOHy2zXtK8SkOJQN3uRYYBXQ8QOAmyhc-VjDzxMI";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            TrailerResponse trailerData = mapper.readValue(response.body(), TrailerResponse.class);

            return trailerData.getResults().stream()
                    .filter(v -> "Trailer".equalsIgnoreCase(v.getType()) && "YouTube".equalsIgnoreCase(v.getSite()))
                    .map(v -> "https://www.youtube.com/watch?v=" + v.getKey())
                    .findFirst()
                    .orElse("N/A");

        } catch (IOException | InterruptedException e) {
            return "N/A";
        }
    }


    @Override
    public MovieResponse getDummyMovie(String movieName , int page) {
        String url =
                String.format("https://api.themoviedb.org/3/search/movie?api_key=bc635944a4e43701982406e7cd2dbda6&query=%s&page=%d",movieName,page);
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiYzYzNTk0NGE0ZTQzNzAxOTgyNDA2ZTdjZDJkYmRhNiIsIm5iZiI6MTc3NjI2MDc4Ny4wNzcsInN1YiI6IjY5ZGY5NmIzMmExNjA0YzI1OWI0Y2I2MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ZNRiOHy2zXtK8SkOJQN3uRYYBXQ8QOAmyhc-VjDzxMI";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .GET()
                .build();
        try{
            HttpResponse<String> response = client.send(
                    request, HttpResponse.BodyHandlers.ofString()
            );
//            System.out.println("Status Code" + response.statusCode());
//            System.out.println("Status " + response.body());
            return mapper.readValue(response.body(), MovieResponse.class);
        }catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }

    }



    @Override
    public MovieInfo getMovieDetail(int id) {
        String url =
                String.format("https://api.themoviedb.org/3/movie/%d?api_key=bc635944a4e43701982406e7cd2dbda6",id);
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiYzYzNTk0NGE0ZTQzNzAxOTgyNDA2ZTdjZDJkYmRhNiIsIm5iZiI6MTc3NjI2MDc4Ny4wNzcsInN1YiI6IjY5ZGY5NmIzMmExNjA0YzI1OWI0Y2I2MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ZNRiOHy2zXtK8SkOJQN3uRYYBXQ8QOAmyhc-VjDzxMI";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .GET()
                .build();
        try{
            HttpResponse<String> response = client.send(
                    request, HttpResponse.BodyHandlers.ofString()
            );
//            System.out.println("Status Code" + response.statusCode());
//            System.out.println("Status " + response.body());
            return mapper.readValue(response.body(), MovieInfo.class);
        }catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public MovieResponse getPopularMovie(int page) {
        String url = String.format("https://api.themoviedb.org/3/movie/popular?api_key=bc635944a4e43701982406e7cd2dbda6&page=%d",page);
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiYzYzNTk0NGE0ZTQzNzAxOTgyNDA2ZTdjZDJkYmRhNiIsIm5iZiI6MTc3NjI2MDc4Ny4wNzcsInN1YiI6IjY5ZGY5NmIzMmExNjA0YzI1OWI0Y2I2MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ZNRiOHy2zXtK8SkOJQN3uRYYBXQ8QOAmyhc-VjDzxMI";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .GET()
                .build();
        try{
            HttpResponse<String> response = client.send(
                    request, HttpResponse.BodyHandlers.ofString()
            );
//            System.out.println("Status Code" + response.statusCode());
//            System.out.println("Status " + response.body());
            return mapper.readValue(response.body(), MovieResponse.class);
        }catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public MovieResponse getTopRatedMovie(int page) {
        String url = String.format("https://api.themoviedb.org/3/movie/top_rated?api_key=bc635944a4e43701982406e7cd2dbda6&page=%d",page);
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiYzYzNTk0NGE0ZTQzNzAxOTgyNDA2ZTdjZDJkYmRhNiIsIm5iZiI6MTc3NjI2MDc4Ny4wNzcsInN1YiI6IjY5ZGY5NmIzMmExNjA0YzI1OWI0Y2I2MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ZNRiOHy2zXtK8SkOJQN3uRYYBXQ8QOAmyhc-VjDzxMI";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .GET()
                .build();
        try{
            HttpResponse<String> response = client.send(
                    request, HttpResponse.BodyHandlers.ofString()
            );
            System.out.println("Status Code" + response.statusCode());
            System.out.println("Status " + response.body());
            return mapper.readValue(response.body(), MovieResponse.class);
        }catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }

//    private void initData(){
//        Random random = new Random();
//        for (int i = 1; i<= 40; i++){
//            Movie movie = new Movie();
//            movie.setId(random.nextInt(9999));
//            movie.setTitle("Pro"+random.nextInt(99));
//            movie.setRelease(new Date());
//        }
//    }

    static void main() {

//        new MovieServiceImpl().getDummyMovie("love",3);
        new MovieServiceImpl().getTopRatedMovie(1);
    }

}
