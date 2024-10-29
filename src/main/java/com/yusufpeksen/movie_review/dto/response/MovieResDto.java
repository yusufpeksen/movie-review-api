package com.yusufpeksen.movie_review.dto.response;

import com.yusufpeksen.movie_review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class MovieResDto {

    private Long id;
    private String title;
    private String genre;
    private LocalDate releaseDate;
    private String director;
    private Double rating;
    private List<ReviewResDto> reviews;
}
