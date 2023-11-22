package az.booking.bookshop.repository;

import az.booking.bookshop.entity.Role;
import az.booking.bookshop.model.response.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query(value = "select r from Role r where  r.roleName =:roleName")
    Role findByRoleName(@Param(value = "roleName") ERole eRole);
}
