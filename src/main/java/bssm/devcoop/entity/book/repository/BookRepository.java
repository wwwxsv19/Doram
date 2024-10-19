package bssm.devcoop.entity.book.repository;

import bssm.devcoop.entity.book.Book;
import bssm.devcoop.entity.book.BookId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, BookId> {
    List<Book> findAllById_UserIdAndBookType(String userId, String bookType);

    List<Book> findBooksByBookTitleContains(String keyword);
    List<Book> findBooksById_UserIdContains(String keyword);
    List<Book> findBooksByBookTagContains(String keyword);
}
