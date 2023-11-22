package az.booking.bookshop.model.response;

import java.util.List;

public record GenreResponse(
        String genreName,
        List<BookResponse> books
) {
}
