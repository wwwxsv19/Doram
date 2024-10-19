package bssm.devcoop.domain.book.service;

import bssm.devcoop.entity.book.Book;
import bssm.devcoop.entity.book.repository.BookRepository;
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


    public List<Book> getPublished(String userId) {
        return bookRepository.findAllById_UserIdAndBookType(userId, publishedType);
    }

    public List<Book> search(String keyword, String where) throws GlobalException {
        if (where.equals("0")) {
            return bookRepository.findBooksByBookTitleContains(keyword);
        } else if(where.equals("1")) {
            return bookRepository.findBooksById_UserIdContains(keyword);
        } else if(where.equals("2")) {
            return bookRepository.findBooksByBookTagContains(keyword);
        }
        throw new GlobalException(ErrorCode.Bad_Request, "Incorrect Where point");
    }

    public int getLikedCount(Long bookId) {
        return 5;
    }

    public int getCommentCount(Long bookId) {
        return 5;
    }
}
