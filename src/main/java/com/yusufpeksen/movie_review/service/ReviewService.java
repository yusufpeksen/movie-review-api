package service;

import com.yusufpeksen.movie_review.utils.DtoMapperUtil;
import dto.request.ReviewReqDto;
import dto.response.ReviewResDto;
import entity.Movie;
import entity.Review;
import exception.MovieNotFoundException;
import exception.UsernameNotFoundException;
import lombok.AllArgsConstructor;
import mapper.MovieResMapper;
import mapper.ReviewReqMapper;
import mapper.ReviewResMapper;
import org.springframework.stereotype.Service;
import repository.MovieRepository;
import repository.ReviewRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewService {

    private MovieRepository movieRepository;
    private ReviewRepository reviewRepository;

    public ReviewResDto addReview(Long movieId , ReviewReqDto reviewReqDto) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new MovieNotFoundException("Movie Not Found with given ID : " + movieId)
        );

        Review addedReview = ReviewReqMapper.INSTANCE.toReview(reviewReqDto);
        addedReview.setMovie(movie);
        reviewRepository.save(addedReview);

        return ReviewResMapper.INSTANCE.toReviewResponseDto(addedReview);
    }

    public List<ReviewResDto> getReviewsByMovieId(Long movieId) {
        List<Review> reviews = reviewRepository.findByMovieId(movieId);
        return DtoMapperUtil.mapToResponseDtoList(reviews, ReviewResMapper.INSTANCE::toReviewResponseDto);
    }

    public List<ReviewResDto> getSortedReviewsByMovieId(Long movieId) {
        List<Review> reviews = reviewRepository.findByMovieId(movieId);
        return reviews.stream()
                .sorted((r1, r2) -> r2.getReviewDate().compareTo(r1.getReviewDate()))
                .map(ReviewResMapper.INSTANCE::toReviewResponseDto)
                .collect(Collectors.toList());
    }

    public List<ReviewResDto> getReviewsByUsername(String username) {
        List<Review> reviews = reviewRepository.findByUsername(username);
        if(reviews.isEmpty()) {
            throw new UsernameNotFoundException("Username Not Found with given username : " + username);
        }
        return DtoMapperUtil.mapToResponseDtoList(reviews, ReviewResMapper.INSTANCE::toReviewResponseDto);
    }
}
