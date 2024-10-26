package bssm.devcoop.domain.book.service;

import aj.org.objectweb.asm.TypeReference;
import bssm.devcoop.domain.book.presentation.dto.SaveDto;
import bssm.devcoop.entity.book.Book;
import bssm.devcoop.entity.book.BookId;
import bssm.devcoop.entity.book.repository.BookRepository;
import bssm.devcoop.entity.book.types.BookCategory;
import bssm.devcoop.entity.book.types.BookType;
import bssm.devcoop.entity.user.User;
import bssm.devcoop.entity.user.repository.UserRepository;
import bssm.devcoop.global.exception.GlobalException;
import bssm.devcoop.global.exception.enums.ErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final String publishedType = "3";
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<Book> search(String keyword, String where) throws GlobalException {
        if (where.equals("0")) {
            return bookRepository.findAllByBookTitleContains(keyword);
        } else if(where.equals("1")) {
            return bookRepository.findAllByUserIdContains(keyword);
        } else if(where.equals("2")) {
            return bookRepository.findAllByBookTagsContains(keyword);
        }
        throw new GlobalException(ErrorCode.BOOK_BAD_REQUEST, "올바르지 못한 검색입니다.");
    }

    @Transactional
    public void save(SaveDto.SaveRequest request, String userId) throws GlobalException {
        List<String> bookTagList = request.getBookTagList();
        Map<String, String> bookTags = bookTagList.stream()
                .collect(Collectors.toMap(String::toString, String::toString));

        try {
            Book book = Book.builder()
                    .userId(userId)
                    .bookTitle(request.getBookTitle())
                    .bookTags(bookTags)
                    .bookCategory(request.getBookCategory())
                    .bookContent(request.getBookContent())
                    .bookType(request.getBookType())
                    .publishedAt(LocalDateTime.now())
                    .build();

            bookRepository.save(book);

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_FOUND, "유저를 찾을 수 없습니다."));

            book.setAuthor(user);

        } catch (Exception e) {
            throw new GlobalException(ErrorCode.BOOK_SERVER_ERROR, "책 저장 도중 에러가 발생하였습니다.");
        }
    }
}
