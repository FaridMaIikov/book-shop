package az.booking.bookshop.repository;


import az.booking.bookshop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {

}
