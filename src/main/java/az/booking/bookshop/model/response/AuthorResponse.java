package az.booking.bookshop.model.response;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;
public record AuthorResponse(
        @Column(name = "full_name")
        String fullName,
        String biography,
        LocalDateTime dateOfBirth,
        List<BookResponse> books
        ) {
}
