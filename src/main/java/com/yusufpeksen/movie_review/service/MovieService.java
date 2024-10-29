package com.yusufpeksen.movie_review.service;

import com.yusufpeksen.movie_review.utils.DtoMapperUtil;
import com.yusufpeksen.movie_review.dto.request.MovieReqDto;
import com.yusufpeksen.movie_review.dto.response.MovieResDto;
import com.yusufpeksen.movie_review.entity.Movie;
import com.yusufpeksen.movie_review.exception.MovieNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import com.yusufpeksen.movie_review.mapper.MovieReqMapper;
import com.yusufpeksen.movie_review.mapper.MovieResMapper;
import org.springframework.stereotype.Service;
import com.yusufpeksen.movie_review.repository.MovieRepository;
import com.yusufpeksen.movie_review.repository.ReviewRepository;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;
    private ReviewRepository reviewRepository;

    public MovieResDto addMovie(MovieReqDto movieReqDto) {
        Movie movie = MovieReqMapper.INSTANCE.toMovie(movieReqDto);
        Movie savedMovie = movieRepository.save(movie);
        return MovieResMapper.INSTANCE.toMovieResponseDto(savedMovie);
    }

    public List<MovieResDto> fetchMovies() {
        List<Movie> movies = movieRepository.findAll();
        return DtoMapperUtil.mapToResponseDtoList(movies, MovieResMapper.INSTANCE::toMovieResponseDto);
    }

    public MovieResDto updateMovie(Long movieId, MovieReqDto movieReqDto) {
        Movie existingMovie = movieRepository.findById(movieId).orElseThrow(
                () -> new MovieNotFoundException("Movie Not Found with given ID : " + movieId)
        );

        MovieReqMapper.INSTANCE.updateMovieFromDto(movieReqDto, existingMovie);
        Movie updatedMovie = movieRepository.save(existingMovie);
        return MovieResMapper.INSTANCE.toMovieResponseDto(updatedMovie);
    }

    public void deleteMovie(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new MovieNotFoundException("Movie Not Found with given ID : " + movieId)
        );
        movieRepository.deleteById(movieId);
    }

    public List<MovieResDto> getMoviesByDirector(String director) {
        List<Movie> movies = movieRepository.findByDirector(director);
        return DtoMapperUtil.mapToResponseDtoList(movies, MovieResMapper.INSTANCE::toMovieResponseDto);
    }

    public List<MovieResDto> getMoviesByGenre(String genre) {
        List<Movie> movies = movieRepository.findByGenre(genre);
        return DtoMapperUtil.mapToResponseDtoList(movies, MovieResMapper.INSTANCE::toMovieResponseDto);
    }

    public List<MovieResDto> getMoviesOrderedByReleaseDateAsc() {
        List<Movie> movies = movieRepository.findAllByOrderByReleaseDateAsc();
        return DtoMapperUtil.mapToResponseDtoList(movies, MovieResMapper.INSTANCE::toMovieResponseDto);
    }

    public List<MovieResDto> getMoviesOrderedByReleaseDateDesc() {
        List<Movie> movies = movieRepository.findAllByOrderByReleaseDateDesc();
        return DtoMapperUtil.mapToResponseDtoList(movies, MovieResMapper.INSTANCE::toMovieResponseDto);
    }

    public List<MovieResDto> searchMoviesByTitle(String title) {
        List<Movie> movies = movieRepository.findByTitleContainingIgnoreCase(title);
        return DtoMapperUtil.mapToResponseDtoList(movies, MovieResMapper.INSTANCE::toMovieResponseDto);
    }

    }

