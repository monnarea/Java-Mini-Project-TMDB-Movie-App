package model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieResponse {
    private List<Movie> movies;
    private Integer total;
    private Integer skip;
    private Integer limit;
}
