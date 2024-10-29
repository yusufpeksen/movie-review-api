package com.yusufpeksen.movie_review.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username" ,nullable = false)
    private String username;

    @Column(name = "comment" , nullable = false)
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id" , referencedColumnName = "id")
    private Movie movie;

    @Column(name = "rating" , nullable = false)
    private Double rating;

    @CreatedDate
    @Column(name = "review_date")
    private LocalDateTime reviewDate;

}
