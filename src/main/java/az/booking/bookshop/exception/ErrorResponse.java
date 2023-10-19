package az.booking.bookshop.exception;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse{
    int statusCode;
    String message;
    LocalDateTime localDateTime;
}
