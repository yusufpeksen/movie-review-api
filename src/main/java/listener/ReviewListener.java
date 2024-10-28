package listener;

import entity.Review;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.MovieService;

@Component
public class ReviewListener {

    @Autowired
    private MovieService movieService;

    @PostPersist
    @PostUpdate
    public void afterReviewSaveOrUpdate(Review review) {
        Long movieId = review.getMovie().getId();
        movieService.updateMovieRating(movieId);
    }
}
