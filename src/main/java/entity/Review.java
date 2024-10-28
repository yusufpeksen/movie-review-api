package entity;

import jakarta.persistence.*;
import listener.ReviewListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@EntityListeners(ReviewListener.class)
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id" , referencedColumnName = "id" , nullable = false)
    private Movie movie;

    @Column(name = "rating" , nullable = false)
    private Double rating;

    @CreatedDate
    @Column(name = "review_date")
    private LocalDateTime reviewDate;

    @Column(name = "username" ,nullable = false)
    private String username;

}
