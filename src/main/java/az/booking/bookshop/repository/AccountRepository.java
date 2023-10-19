package az.booking.bookshop.repository;

import az.booking.bookshop.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
