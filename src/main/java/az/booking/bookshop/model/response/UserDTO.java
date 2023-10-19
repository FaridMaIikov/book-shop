package az.booking.bookshop.model.response;

public record UserDTO(
        String firstName,
        String lastName,
        String email,
        String contactNumber
) {
}
