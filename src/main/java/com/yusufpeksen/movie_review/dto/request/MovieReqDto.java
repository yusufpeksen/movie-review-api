package com.yusufpeksen.movie_review.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MovieReqDto {

    private String title;
    private String genre;
    private LocalDate releaseDate;
    private String director;

}
