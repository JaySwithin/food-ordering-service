package com.swithin.fooddeliveryservice.errors;

import com.swithin.fooddeliveryservice.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestResponseExceptionHandler {
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDTO> userAlreadyExistException(UserAlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ErrorResponseDTO.builder()
                        .success(false)
                        .message(exception.getMessage())
                        .build()
                );
    }

    @ExceptionHandler({
            UserNotFoundException.class,
            MenuItemNotFoundException.class,
            RestaurantNotFoundException.class,
            OrderNotFoundException.class
    })
    public ResponseEntity<ErrorResponseDTO> entityNotFoundExceptionHandler(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponseDTO.builder()
                        .success(false)
                        .message(exception.getMessage())
                        .build());
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ErrorResponseDTO> authException(AuthException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ErrorResponseDTO.builder()
                        .success(false)
                        .message(exception.getMessage())
                        .build());
    }

}
