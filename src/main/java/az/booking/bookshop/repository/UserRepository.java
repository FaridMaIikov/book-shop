package az.booking.bookshop.repository;


import az.booking.bookshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByAccount_Username(@Param(value = "username") String username);
}
