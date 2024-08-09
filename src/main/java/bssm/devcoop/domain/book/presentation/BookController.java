package bssm.devcoop.domain.book.presentation;

import bssm.devcoop.domain.book.Book;
import bssm.devcoop.domain.book.presentation.dto.ReadDto;
import bssm.devcoop.domain.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;

    @GetMapping("/books/{userId}")
    public ResponseEntity<?> publishedBookList(@PathVariable String userId) {
        log.info("Get Published Book List from User : {}", userId);

        List<Book> bookList = bookService.getPublished(userId);
        List<ReadDto.BookList> readBookList = new ArrayList<>();
        int bookCount = 0;

        for(Book book : bookList) {
            ReadDto.BookList bookRes = ReadDto.BookList.builder()
                    .bookId(book.getId().getBookId())
                    .userId(book.getId().getUserId())
                    .bookTitle(book.getBookTitle())
                    .bookCategory(book.getBookCategory())
                    .bookType(book.getBookType())
                    .build();

            readBookList.add(bookRes);
        }

        ReadDto.BooksResponse response = ReadDto.BooksResponse.builder()
                .bookList(readBookList)
                .bookCount(bookCount)
                .build();

        return ResponseEntity.ok().body(response);
    }
}
