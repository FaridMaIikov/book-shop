package az.booking.bookshop.repository;


import az.booking.bookshop.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface AuthorRepository extends  JpaRepository<Author, Long> {

    @Query(value = "select a from Author a where a.fullName =:fullName")
    Optional<Author> findAuthorByFullName(@Param("fullName") String fullName);
}
