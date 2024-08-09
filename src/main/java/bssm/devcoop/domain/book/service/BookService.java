package bssm.devcoop.domain.book.service;

import bssm.devcoop.domain.book.Book;
import bssm.devcoop.domain.book.repository.BookRepository;
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
}
