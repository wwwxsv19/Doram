package bssm.devcoop.domain.book.presentation;

import bssm.devcoop.entity.book.Book;
import bssm.devcoop.domain.book.service.BookService;
import bssm.devcoop.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;

    @GetMapping("/search")
    public ResponseEntity<?> searchBooks(@RequestParam String keyword, String where) throws GlobalException {
        log.info("Search Books from keyword : {} from : {}", keyword, where);

        List<Book> searchList = bookService.search(keyword, where);

        return ResponseEntity.ok().body(searchList);
    }
}
