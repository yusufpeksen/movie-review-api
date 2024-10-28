package mapper;

import dto.request.ReviewReqDto;
import entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewReqMapper {

    ReviewReqMapper INSTANCE = Mappers.getMapper(ReviewReqMapper.class);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "comment", target = "comment")
    @Mapping(source = "rating", target = "rating")
    @Mapping(source = "movie", target = "movie")
    Review toReview(ReviewReqDto dto);


}
