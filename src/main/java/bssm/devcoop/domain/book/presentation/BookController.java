package bssm.devcoop.domain.book.presentation;

import bssm.devcoop.domain.book.presentation.dto.SaveDto;
import bssm.devcoop.entity.book.Book;
import bssm.devcoop.domain.book.service.BookService;
import bssm.devcoop.entity.book.types.BookCategory;
import bssm.devcoop.entity.book.types.BookType;
import bssm.devcoop.entity.user.CustomUserDetails;
import bssm.devcoop.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book", produces = "application/json; charset=UTF8")
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

    @PostMapping("/save")
    public ResponseEntity<?> saveBook(@RequestBody SaveDto.SaveRequest request) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userId = userDetails.getUserId();

        log.info("Save Book from User : {}", userId);

        try {
            bookService.save(request, userId);
        } catch (GlobalException e) {
            return ResponseEntity.status(e.getErrorCode().getStatus()).body(e.getMessage());
        }

        SaveDto.SaveResponse response = SaveDto.SaveResponse.builder()
                .message("성공적으로 책을 저장하였습니다!")
                .build();

        return ResponseEntity.ok().body(response);
    }
}
