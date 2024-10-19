package bssm.devcoop.entity.book;

import bssm.devcoop.entity.mapping.comment.Comment;
import bssm.devcoop.entity.mapping.favorite.Favorite;
import bssm.devcoop.entity.mapping.liked.Liked;
import bssm.devcoop.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Table(name = "doram_book")
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @EmbeddedId
    private BookId id;

    private String bookTitle;

    private String bookTag; // JSON

    private char bookCategory;

    private String bookContent;

    private char bookType;

    private String publishedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User userId;

    @OneToMany(
            mappedBy = "bookId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Liked> likedList = new ArrayList<>();

    @OneToMany(
            mappedBy = "bookId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(
            mappedBy = "bookId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Favorite> favoriteList = new ArrayList<>();
}
