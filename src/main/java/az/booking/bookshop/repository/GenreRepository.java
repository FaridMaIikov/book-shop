package az.booking.bookshop.repository;


import az.booking.bookshop.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("select g from Genre g where g.genreName=:genreName")
    Genre findByGenreName(@Param("genreName") String genreName);
}
