package com.yusufpeksen.movie_review.mapper;

import com.yusufpeksen.movie_review.dto.request.ReviewReqDto;
import com.yusufpeksen.movie_review.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewReqMapper {

    ReviewReqMapper INSTANCE = Mappers.getMapper(ReviewReqMapper.class);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "comment", target = "comment")
    @Mapping(source = "rating", target = "rating")
    Review toReview(ReviewReqDto dto);


}
