package az.booking.bookshop.entity;


import az.booking.bookshop.model.response.ERole;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    Set<User> users;

}
