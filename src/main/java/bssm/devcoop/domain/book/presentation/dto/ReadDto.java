package bssm.devcoop.domain.book.presentation.dto;

import lombok.Builder;

import java.util.List;

public class ReadDto {
    @Builder
    public static class BookList {
        private Long bookId;
        private String userId;
        private String bookTitle;
        private int likedCount;
        private int commentCount;
    }

    @Builder
    public static class BooksResponse {
        private List<BookList> bookList;
        private int bookCount;
    }
}
