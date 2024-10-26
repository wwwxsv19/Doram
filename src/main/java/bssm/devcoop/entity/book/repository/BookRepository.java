package bssm.devcoop.entity.book.repository;

import bssm.devcoop.entity.book.Book;
import bssm.devcoop.entity.book.BookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, BookId> {
    List<Book> findAllByUserIdAndBookType(String userId, String bookType);

    List<Book> findAllByBookTitleContains(String keyword);
    List<Book> findAllByUserIdContains(String keyword);
    @Query(value = "SELECT b FROM doram_book b WHERE JSON_CONTAINS(e.bookTags, :tagValue, '$')", nativeQuery = true)
    List<Book> findAllByBookTagsContains(String tagValue);

}
