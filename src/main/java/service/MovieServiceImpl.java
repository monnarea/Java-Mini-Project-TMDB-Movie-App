package service;

import model.Movie;
import model.MovieResponse;
import tools.jackson.databind.ObjectMapper;

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

    @Override
    public MovieResponse getDummyMovie(int skip , int limit) {
        String url =
                String.format("https://dummyjson.com/products?skip=%d&limit=%d",skip,limit);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
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
        new MovieServiceImpl().getDummyMovie(10,10);
    }
}
