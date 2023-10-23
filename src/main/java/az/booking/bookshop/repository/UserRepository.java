package az.booking.bookshop.repository;


import az.booking.bookshop.entity.User;
import az.booking.bookshop.model.response.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

}
