package bssm.devcoop.domain.book.entity.liked;

import bssm.devcoop.domain.book.Book;
import bssm.devcoop.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table
@Data
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Liked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likedId;

    @Column(name = "createdAt")
    private LocalDate createdAt;

    @ManyToOne(fetch = FetchType.LAZY) // one agenda -> many vote
    @JoinColumns({
            @JoinColumn(name = "bookId"),
            @JoinColumn(name = "userId")
    })
    @JsonBackReference
    private Book book;

    @Builder
    public Liked(Long likedId, LocalDate createdAt, User user, Book book) {
        this.likedId = likedId;
        this.createdAt = createdAt;
        this.book = book;
    }
}
