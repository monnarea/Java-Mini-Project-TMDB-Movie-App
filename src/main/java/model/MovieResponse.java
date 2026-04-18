package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieResponse {
    private List<Movie> results;
    private Integer page;
    private Integer totalPages;
    private Integer totalResults;
//    private List<Movie> movies;
//    private Integer total;
////    private Integer skip;
////    private Integer limit;
//    private Integer page;
}
