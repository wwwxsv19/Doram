package bssm.devcoop.domain.user.presentation.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class UserReadDto {
    @Builder
    @Getter
    public static class Books {
        private int bookId;
        private String bookTitle;
        private LocalDateTime publishedAt;
        private int likedCount;
        private int commentCount;
    }

    @Builder
    @Getter
    public static class BooksResponse {
        private int bookCount;
        private List<Books> bookList;
    }
}
