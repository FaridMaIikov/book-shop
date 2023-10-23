package az.booking.bookshop.repository;


import az.booking.bookshop.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("select g from Genre g left join fetch g.books where g.genreName=:genreName ")
    Optional<Genre> findByGenreName(@Param("genreName") String genreName);
}
