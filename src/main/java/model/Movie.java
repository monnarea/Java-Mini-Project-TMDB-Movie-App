package model;

import lombok.*;

import javax.xml.crypto.Data;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {
    private Integer id;
    private String title;
//    private Date release;
    private String category;
//    private Double rating;
    private Double price;
    private Double rating;
//    private String trailer;
}
