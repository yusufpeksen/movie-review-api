package com.yusufpeksen.movie_review.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private Long id;

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "genre" , nullable = false)
    private String genre;

    @Column(name = "release_date" ,nullable = false)
    private LocalDate releaseDate;

    @Column(name = "director")
    private String director;

    @Column(name = "rating")
    private Double rating;

    @OneToMany(mappedBy = "movie" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Review> reviews;

}
