package dto.response;

import entity.Movie;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewResDto {

    private String username;
    private String comment;
    private Double rating;
    private Movie movie;
    private LocalDateTime reviewDate;
}
