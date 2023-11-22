package az.booking.bookshop.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

    String firstName;
    String lastName;
    String email;
    String contactNumber;
    String username;
}
