package bssm.devcoop.domain.book;

import bssm.devcoop.domain.book.entity.liked.Liked;
import bssm.devcoop.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "bookWriter")
    private String bookWriter;

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

    @OneToMany(
            mappedBy = "book",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Liked> likedList = new ArrayList<>();

    @Builder
    public Book(
            BookId id, String bookTitle, String bookWriter,
            String bookTag, char bookCategory, String bookContent,
            char bookType, String publishedAt, User user) {
        this.id = id;
        this .bookTitle = bookTitle;
        this.bookWriter = bookWriter;
        this.bookTag = bookTag;
        this.bookCategory = bookCategory;
        this.bookContent = bookContent;
        this.bookType = bookType;
        this.publishedAt = publishedAt;
        this.user = user;
    }
}
