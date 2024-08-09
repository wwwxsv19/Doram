package bssm.devcoop.domain.user;

import bssm.devcoop.domain.book.Book;
import bssm.devcoop.domain.user.types.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @Column(name = "userId")
    private String userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userIntroduce")
    private String userIntroduce;

    @Column(name = "userImage")
    private String userImage;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "userBirth")
    private LocalDate userBirth;

    @Column(name = "userPassword")
    private String userPassword;

    @Column(name = "joinedAt")
    private LocalDate joinedAt;

    @Column(name = "roles")
    private Role roles;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Book> bookList = new ArrayList<>();

    @Builder
    public User(
            String userId, String userName, String userIntroduce,
            String userImage, String userEmail, LocalDate userBirth,
            String userPassword, LocalDate joinedAt, Role roles) {
        this.userId = userId;
        this.userName = userName;
        this.userIntroduce = userIntroduce;
        this.userImage = userImage;
        this.userEmail = userEmail;
        this.userBirth = userBirth;
        this.userPassword = userPassword;
        this.joinedAt = joinedAt;
        this.roles = roles;
    }
}
