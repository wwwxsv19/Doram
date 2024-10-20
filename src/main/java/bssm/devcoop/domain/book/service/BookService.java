package bssm.devcoop.domain.book.service;

import bssm.devcoop.entity.book.Book;
import bssm.devcoop.entity.book.repository.BookRepository;
import bssm.devcoop.entity.user.User;
import bssm.devcoop.global.exception.GlobalException;
import bssm.devcoop.global.exception.enums.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final String publishedType = "3";
    private final BookRepository bookRepository;

    public List<Book> search(String keyword, String where) throws GlobalException {
        if (where.equals("0")) {
            return bookRepository.findBooksByBookTitleContains(keyword);
        } else if(where.equals("1")) {
            return bookRepository.findBooksById_UserIdContains(keyword);
        } else if(where.equals("2")) {
            return bookRepository.findBooksByBookTagContains(keyword);
        }
        throw new GlobalException(ErrorCode.BOOK_BAD_REQUEST, "올바르지 못한 검색입니다.");
    }
}
