package bssm.devcoop.domain.book;

import bssm.devcoop.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @EmbeddedId
    private BookId id;

    @Column(name = "bookTitle")
    private String bookTitle;

    @Column(name = "bookTag")
    private String bookTag; // JSON

    @Column(name = "bookCategory")
    private char bookCategory;

    @Column(name = "bookContent")
    private String bookContent;

    @Column(name = "bookType")
    private char bookType;

    @Column(name = "publishedAt")
    private String publishedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;

    @Builder
    public Book(
            BookId id, String bookTitle, String bookTag,
            char bookCategory, String bookContent, char bookType,
            String publishedAt, User user) {
        this.id = id;
        this .bookTitle = bookTitle;
        this.bookTag = bookTag;
        this.bookCategory = bookCategory;
        this.bookContent = bookContent;
        this.bookType = bookType;
        this.publishedAt = publishedAt;
        this.user = user;
    }
}
