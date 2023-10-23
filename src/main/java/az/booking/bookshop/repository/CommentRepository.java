package az.booking.bookshop.repository;


import az.booking.bookshop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c left join fetch c.book left join fetch c.user")
    List<Comment> getAllComments();
}
