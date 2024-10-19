package bssm.devcoop.entity.mapping.follow;

import bssm.devcoop.entity.book.Book;
import bssm.devcoop.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "doram_follow")
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int followId;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fromUser")
    @JsonBackReference
    private User fromUser; // 팔로우한 사람

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "toUser")
    @JsonBackReference
    private User toUser; // 팔로우 당한 사람
}
