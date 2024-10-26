package bssm.devcoop.domain.book.presentation.dto;

import bssm.devcoop.entity.book.types.BookCategory;
import bssm.devcoop.entity.book.types.BookType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class SaveDto {
    @Getter
    public static class SaveRequest {
        private String bookTitle;
        private List<String> bookTagList;
        private BookCategory bookCategory;
        private String bookContent;
        private BookType bookType;
    }

    @Builder
    @Getter
    public static class SaveResponse {
        private String message;
    }
}
