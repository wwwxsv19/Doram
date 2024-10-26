package bssm.devcoop.entity.book;

import bssm.devcoop.entity.book.types.BookCategory;
import bssm.devcoop.entity.book.types.BookType;
import bssm.devcoop.entity.mapping.comment.Comment;
import bssm.devcoop.entity.mapping.favorite.Favorite;
import bssm.devcoop.entity.mapping.liked.Liked;
import bssm.devcoop.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Builder
@Entity
@Table(name = "doram_book")
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String userId;

    private String bookTitle;

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> bookTags; // JSON

    @Enumerated(EnumType.STRING)
    private BookCategory bookCategory;

    private String bookContent;

    @Enumerated(EnumType.STRING)
    private BookType bookType;

    private LocalDateTime publishedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    @JsonBackReference
    private User user;

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

    public void setAuthor(User user) {
        this.user = user;
        user.addBookList(this);
    }
}
