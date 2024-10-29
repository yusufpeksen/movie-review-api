package com.yusufpeksen.movie_review.service;

import com.yusufpeksen.movie_review.utils.DtoMapperUtil;
import com.yusufpeksen.movie_review.dto.request.ReviewReqDto;
import com.yusufpeksen.movie_review.dto.response.ReviewResDto;
import com.yusufpeksen.movie_review.entity.Movie;
import com.yusufpeksen.movie_review.entity.Review;
import com.yusufpeksen.movie_review.exception.MovieNotFoundException;
import com.yusufpeksen.movie_review.exception.UsernameNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import com.yusufpeksen.movie_review.mapper.ReviewReqMapper;
import com.yusufpeksen.movie_review.mapper.ReviewResMapper;
import org.springframework.stereotype.Service;
import com.yusufpeksen.movie_review.repository.MovieRepository;
import com.yusufpeksen.movie_review.repository.ReviewRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewService {

    private MovieRepository movieRepository;
    private ReviewRepository reviewRepository;

    @Transactional
    public ReviewResDto addReview(Long movieId , ReviewReqDto reviewReqDto) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new MovieNotFoundException("Movie Not Found with given ID : " + movieId)
        );

        Review addedReview = ReviewReqMapper.INSTANCE.toReview(reviewReqDto);
        addedReview.setMovie(movie);

        ReviewResDto reviewResDto = ReviewResMapper.INSTANCE.toReviewResponseDto(addedReview);
        reviewResDto.setMovieTitle(movie.getTitle());

        reviewRepository.save(addedReview);

        return reviewResDto;
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
