package mapper;

import dto.response.MovieResDto;
import dto.response.ReviewResDto;
import entity.Movie;
import entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper
public interface ReviewResMapper {

    ReviewResMapper INSTANCE = Mappers.getMapper(ReviewResMapper.class);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "comment", target = "comment")
    @Mapping(source = "rating", target = "rating")
    @Mapping(source = "movie", target = "movie")
    @Mapping(source = "reviewDate", target = "reviewDate")
    ReviewResDto toReviewResponseDto(Review review);

}
