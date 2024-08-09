package bssm.devcoop.domain.book.repository;

import bssm.devcoop.domain.book.Book;
import bssm.devcoop.domain.book.BookId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, BookId> {
    List<Book> findAllById_UserIdAndBookType(String userId, String bookType);

    List<Book> findBooksByBookTitleContains(String keyword);
    List<Book> findBooksByBookWriterContains(String keyword);
    List<Book> findBooksByBookTagContains(String keyword);
}
