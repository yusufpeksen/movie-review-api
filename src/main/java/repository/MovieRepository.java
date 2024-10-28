package repository;

import entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie , Long> {

    List<Movie> findByDirector(String director);
    List<Movie> findByGenre(String genre);
    List<Movie> findByReleaseDateOrderByReleaseDateAsc();
    List<Movie> findByReleaseDateOrderByReleaseDateDesc();
}
