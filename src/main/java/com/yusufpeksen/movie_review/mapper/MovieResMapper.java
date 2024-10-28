package mapper;

import dto.response.MovieResDto;
import entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface MovieResMapper {

    MovieResMapper INSTANCE = Mappers.getMapper(MovieResMapper.class);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "director", target = "director")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "rating", target = "rating")
    @Mapping(source = "reviews", target = "reviews")
    MovieResDto toMovieResponseDto(Movie movie);


}
