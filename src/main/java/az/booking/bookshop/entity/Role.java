package az.booking.bookshop.entity;


import az.booking.bookshop.model.response.ERole;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    ERole roleName;

}
