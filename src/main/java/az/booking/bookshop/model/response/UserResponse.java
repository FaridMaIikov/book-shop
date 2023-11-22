package az.booking.bookshop.model.response;

public record UserResponse(
        String firstName,
        String lastName,
        String email,
        String contactNumber
) {
}
