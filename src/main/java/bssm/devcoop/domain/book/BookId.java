package bssm.devcoop.domain.book;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookId {
    @Column(name = "bookId")
    private Long bookId;

    @Column(name = "userId")
    private String userId;

    @Builder
    public BookId(Long bookId, String userId) {
        this.bookId = bookId;
        this.userId = userId;
    }
}
