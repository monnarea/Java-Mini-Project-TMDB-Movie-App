package model;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieInfo {
    private String name;
    private String releaseDate;
    private Double voteAverage;
    private Integer runtime;
    private Double budget;
    private Genres[] genres;
    private String originalCountry;
}
