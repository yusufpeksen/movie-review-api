package com.yusufpeksen.movie_review.mapper;

import com.yusufpeksen.movie_review.dto.response.MovieResDto;
import com.yusufpeksen.movie_review.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface MovieResMapper {

    MovieResMapper INSTANCE = Mappers.getMapper(MovieResMapper.class);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "director", target = "director")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "rating", target = "rating")
    @Mapping(source = "reviews", target = "reviews")
    MovieResDto toMovieResponseDto(Movie movie);

    List<MovieResDto> toMovieResponseDtoList(List<Movie> movies);
}
