package com.yusufpeksen.movie_review.repository;

import com.yusufpeksen.movie_review.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie , Long> {

    List<Movie> findByDirector(String director);
    List<Movie> findByGenre(String genre);
    List<Movie> findAllByOrderByReleaseDateAsc();
    List<Movie> findAllByOrderByReleaseDateDesc();
    List<Movie> findByTitleContainingIgnoreCase(String title);
}
