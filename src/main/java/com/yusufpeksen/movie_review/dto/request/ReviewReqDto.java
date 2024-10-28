package dto.request;

import entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewReqDto {

    private String username;
    private String comment;
    private Double rating;
    private Movie movie;
}
