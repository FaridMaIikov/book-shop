package az.booking.bookshop.model.response;



import java.time.LocalDateTime;

public record CommentDTO(
        String reviewText,
        Integer likeCount,
        LocalDateTime reviewDate,
        UserDTO userDTO,
        BookDTO bookDTO
) {
}
