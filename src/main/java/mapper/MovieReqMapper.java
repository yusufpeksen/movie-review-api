package mapper;

import dto.request.MovieReqDto;
import entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieReqMapper {

    MovieReqMapper INSTANCE = Mappers.getMapper(MovieReqMapper.class);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "director", target = "director")
    Movie toMovie(MovieReqDto dto);

    void updateMovieFromDto(MovieReqDto dto , @MappingTarget Movie movie);

}
