package com.yusufpeksen.movie_review.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DtoMapperUtil {

    public static <T, R> List<R> mapToResponseDtoList(List<T> sourceList, Function<T, R> mapperFunction) {
        return sourceList.stream()
                .map(mapperFunction)
                .collect(Collectors.toList());
    }
}
