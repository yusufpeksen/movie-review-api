package com.yusufpeksen.movie_review.dto.response;

import com.yusufpeksen.movie_review.entity.Movie;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReviewResDto {

    private String username;
    private String comment;
    private Double rating;
    private LocalDate reviewDate;
    private String movieTitle;
}
