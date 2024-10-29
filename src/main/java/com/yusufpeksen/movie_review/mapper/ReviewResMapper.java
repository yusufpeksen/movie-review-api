package com.yusufpeksen.movie_review.mapper;

import com.yusufpeksen.movie_review.dto.response.ReviewResDto;
import com.yusufpeksen.movie_review.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewResMapper {

    ReviewResMapper INSTANCE = Mappers.getMapper(ReviewResMapper.class);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "comment", target = "comment")
    @Mapping(source = "rating", target = "rating")
    @Mapping(source = "reviewDate", target = "reviewDate")
    @Mapping(source = "movie.title", target = "movieTitle")
    ReviewResDto toReviewResponseDto(Review review);
}
