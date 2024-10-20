package bssm.devcoop.entity.user;

import bssm.devcoop.entity.book.Book;
import bssm.devcoop.entity.mapping.comment.Comment;
import bssm.devcoop.entity.mapping.favorite.Favorite;
import bssm.devcoop.entity.mapping.follow.Follow;
import bssm.devcoop.entity.mapping.liked.Liked;
import bssm.devcoop.entity.user.types.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Table(name = "doram_user")
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    private String userId;

    private String userName;

    private String userIntroduce;

    private String userImage;

    private String userEmail;

    private LocalDate userBirth;

    private String userPassword;

    private LocalDateTime joinedAt;

    @Enumerated(EnumType.STRING)
    private Role roles;

    @OneToMany(
            mappedBy = "userId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Book> bookList = new ArrayList<>();

    @OneToMany(
            mappedBy = "toUser",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Follow> followerList = new ArrayList<>();

    @OneToMany(
            mappedBy = "fromUser",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Follow> followingList = new ArrayList<>();
}
