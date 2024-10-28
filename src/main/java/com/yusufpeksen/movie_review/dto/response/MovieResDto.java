package dto.response;

import entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class MovieResDto {

    private Long id;
    private String title;
    private String genre;
    private LocalDateTime releaseDate;
    private String director;
    private Double rating;
    private List<Review> reviews;
}
