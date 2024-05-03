package com.example.rest.advice;
import com.example.rest.exception.InvalidCredentials;
import com.example.rest.exception.UnauthorizedUser;
import com.example.rest.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice

public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<Message> invalidCredentials(InvalidCredentials exception) {
        Message message = new Message(exception.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<Message> mismatchException(UnauthorizedUser exception) {
        Message message = new Message(exception.getMessage());
        System.out.println(message);
        return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
    }

}
