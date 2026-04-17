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
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("original_title")
    private String originalTitle;

    @JsonProperty("release_date")
    private String releaseDate;   // ← use String, not Date (format is "2024-01-15")

    @JsonProperty("vote_average")
    private Double voteAverage;

    @JsonProperty("video")        // or whatever field "movie" is meant to map to
    private String movie;
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
