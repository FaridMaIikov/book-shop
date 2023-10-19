package az.booking.bookshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    String email;

    @Column(name = "contact_number")
    String contactNumber;

    @Column(name = "registration_date", columnDefinition = "timestamp default now()")
    LocalDateTime registrationDate;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "account_id")
    Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Comment> comments;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles;
}
