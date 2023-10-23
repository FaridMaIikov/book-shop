package az.booking.bookshop.model.response;

import java.util.List;

public record GenreDTO(
        String genreName,
        List<BookDTO> books
) {
}
