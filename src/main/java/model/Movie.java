package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.xml.crypto.Data;
import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {
//    @JsonProperty("id")
    private Integer id;

    @JsonProperty("original_title")
    private String originalTitle;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("vote_average")
    private Double voteAverage;

//    private Integer id;
//    private String originalTitle;
//    private Date releaseDate;
////    private String category;
//    private Double voteAverage;
////    private Double price;
////    private Double rating;
//    private String movie;
//    private Integer page;
//    private Integer totalPages;
}
