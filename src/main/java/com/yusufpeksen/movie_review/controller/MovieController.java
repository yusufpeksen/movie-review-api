package com.yusufpeksen.movie_review.controller;

import com.yusufpeksen.movie_review.dto.request.MovieReqDto;
import com.yusufpeksen.movie_review.dto.response.MovieResDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.yusufpeksen.movie_review.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResDto> addMovie(@RequestBody MovieReqDto movieReqDto) {
        MovieResDto movieResDto = movieService.addMovie(movieReqDto);
        return ResponseEntity.ok(movieResDto);
    }

    @GetMapping
    public ResponseEntity<List<MovieResDto>> getAllMovies() {
        List<MovieResDto> movies = movieService.fetchMovies();
        return ResponseEntity.ok(movies);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<MovieResDto> updateMovie(@PathVariable Long movieId, @RequestBody MovieReqDto movieReqDto) {
        MovieResDto updatedMovie = movieService.updateMovie(movieId, movieReqDto);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/director/{director}")
    public ResponseEntity<List<MovieResDto>> getMoviesByDirector(@PathVariable String director) {
        List<MovieResDto> movies = movieService.getMoviesByDirector(director);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieResDto>> getMoviesByGenre(@PathVariable String genre) {
        List<MovieResDto> movies = movieService.getMoviesByGenre(genre);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/orderByReleaseDateAsc")
    public ResponseEntity<List<MovieResDto>> getMoviesOrderedByReleaseDateAsc() {
        List<MovieResDto> movies = movieService.getMoviesOrderedByReleaseDateAsc();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/orderByReleaseDateDesc")
    public ResponseEntity<List<MovieResDto>> getMoviesOrderedByReleaseDateDesc() {
        List<MovieResDto> movies = movieService.getMoviesOrderedByReleaseDateDesc();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<MovieResDto>> searchMoviesByTitle(@PathVariable String title) {
        List<MovieResDto> movies = movieService.searchMoviesByTitle(title);
        return ResponseEntity.ok(movies);
    }



}
