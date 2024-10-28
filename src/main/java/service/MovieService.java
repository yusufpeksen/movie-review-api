package service;

import dto.request.MovieReqDto;
import entity.Movie;
import exception.MovieNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mapper.MovieReqMapper;
import org.springframework.stereotype.Service;
import repository.MovieRepository;
import repository.ReviewRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;
    private ReviewRepository reviewRepository;

    public void addMovie(MovieReqDto movieReqDto) {
        Movie movie = MovieReqMapper.INSTANCE.toMovie(movieReqDto);
        movieRepository.save(movie);
    }

    public boolean updateMovie(Long movieId, MovieReqDto movieReqDto) {
        Movie existingMovie = movieRepository.findById(movieId).orElseThrow(
                () -> new MovieNotFoundException("Movie Not Found with given ID : " + movieId)
        );

        MovieReqMapper.INSTANCE.updateMovieFromDto(movieReqDto , existingMovie);
        movieRepository.save(existingMovie);
        return true;
    }

    public boolean deleteMovie(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new MovieNotFoundException("Movie Not Found with given ID : " + movieId)
        );
        movieRepository.deleteById(movieId);
        return true;
    }

    public List<Movie> getMoviesByDirector(String director) {
        return movieRepository.findByDirector(director);
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> getMoviesOrderedByReleaseDateAsc() {
        return movieRepository.findByReleaseDateOrderByReleaseDateAsc();
    }

    public List<Movie> getMoviesOrderedByReleaseDateDesc() {
        return movieRepository.findByReleaseDateOrderByReleaseDateDesc();
    }

    @Transactional
    public void updateMovieRating(Long movieId) {
        Double avgRating  = reviewRepository.findAverageRatingByMovieId(movieId);

        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new MovieNotFoundException("Movie Not Found with given ID : " + movieId)
        );

        movie.setRating(avgRating);
        movieRepository.save(movie);
        }
    }

