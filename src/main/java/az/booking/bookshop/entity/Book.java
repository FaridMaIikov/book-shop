package az.booking.bookshop.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "synopsis", length = 1000)
    String synopsis;

    @ManyToMany(mappedBy = "books")
    List<Author> authors;

    @OneToMany(mappedBy = "book")
    List<Comment> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    Genre genreName;
}
