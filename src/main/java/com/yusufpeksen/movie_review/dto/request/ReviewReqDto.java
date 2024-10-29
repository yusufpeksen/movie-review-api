package com.yusufpeksen.movie_review.dto.request;

import com.yusufpeksen.movie_review.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewReqDto {

    private String username;
    private String comment;
    private Double rating;
    private Long movieId;
}
