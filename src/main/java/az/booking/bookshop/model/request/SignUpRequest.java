package az.booking.bookshop.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpRequest {

    @NotBlank
    String username;

    @NotBlank
    String password;

    @NotNull
    String firstName;

    @NotNull
    String lastName;

    @Email
    String email;

    String contactNumber;
}
