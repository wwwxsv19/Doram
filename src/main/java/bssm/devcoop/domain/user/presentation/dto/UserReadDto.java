package bssm.devcoop.domain.user.presentation.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class UserReadDto {
    @Builder
    @Getter
    public static class Books {
        private int bookId;
        private String userId;
        private String bookTitle;
        private int likedCount;
        private int commentCount;
    }

    @Builder
    @Getter
    public static class BooksResponse {
        private List<Books> bookList;
    }
}
