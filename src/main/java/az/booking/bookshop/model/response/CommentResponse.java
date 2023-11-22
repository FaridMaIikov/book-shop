package az.booking.bookshop.model.response;



import java.time.LocalDateTime;

public record CommentResponse(
        String reviewText,
        Integer likeCount,
        LocalDateTime reviewDate,
        UserResponse userResponse,
        BookResponse bookResponse
) {
}
