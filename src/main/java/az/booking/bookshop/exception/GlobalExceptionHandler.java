package az.booking.bookshop.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ErrorResponse handleUserNotFoundException(UserNotFoundException exception) {
        return response(exception, HttpStatus.NOT_FOUND.value());
    }

    private <T extends RuntimeException> ErrorResponse response(T exception, int statusCode) {
        return new ErrorResponse(statusCode, exception.getMessage(), LocalDateTime.now());
    }
}
