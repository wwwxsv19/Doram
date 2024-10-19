package bssm.devcoop.domain.book.presentation;

import bssm.devcoop.entity.book.Book;
import bssm.devcoop.domain.book.presentation.dto.ReadDto;
import bssm.devcoop.domain.book.service.BookService;
import bssm.devcoop.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            Long bookId = book.getId().getBookId();;
            ReadDto.BookList bookRes = ReadDto.BookList.builder()
                    .bookId(bookId)
                    .userId(userId)
                    .bookTitle(book.getBookTitle())
                    .likedCount(bookService.getLikedCount(bookId))
                    .commentCount(bookService.getCommentCount(bookId))
                    .build();

            readBookList.add(bookRes);
        }

        ReadDto.BooksResponse response = ReadDto.BooksResponse.builder()
                .bookList(readBookList)
                .bookCount(bookCount)
                .build();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchBooks(@RequestParam String keyword, String where) throws GlobalException {
        log.info("Search Books from keyword : {} from : {}", keyword, where);

        List<Book> searchList = bookService.search(keyword, where);

        return ResponseEntity.ok().body(searchList);
    }
}
