package bssm.devcoop.entity.book;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookId {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private Long bookId;

    @Column(name = "userId")
    private String userId;
}
