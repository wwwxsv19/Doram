package bssm.devcoop.domain.user.presentation.dto;

import lombok.Builder;

import java.util.List;

public class UserReadDto {
    @Builder
    public static class Books {
        private Long bookId;
        private String userId;
        private String bookTitle;
        private int likedCount;
        private int commentCount;
    }

    @Builder
    public static class BooksResponse {
        private List<Books> bookList;
    }
}
