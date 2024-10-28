package controller;

import dto.request.ReviewReqDto;
import dto.response.ReviewResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/movie/{movieId}")
    public ResponseEntity<ReviewResDto> addReview(@PathVariable Long movieId, @RequestBody ReviewReqDto reviewReqDto) {
        ReviewResDto reviewResDto = reviewService.addReview(movieId, reviewReqDto);
        return ResponseEntity.ok(reviewResDto);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<ReviewResDto>> getReviewsByMovieId(@PathVariable Long movieId) {
        List<ReviewResDto> reviews = reviewService.getReviewsByMovieId(movieId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/movie/{movieId}/sorted")
    public ResponseEntity<List<ReviewResDto>> getSortedReviewsByMovieId(@PathVariable Long movieId) {
        List<ReviewResDto> reviews = reviewService.getSortedReviewsByMovieId(movieId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<ReviewResDto>> getReviewsByUsername(@PathVariable String username) {
        List<ReviewResDto> reviews = reviewService.getReviewsByUsername(username);
        return ResponseEntity.ok(reviews);
    }
}
