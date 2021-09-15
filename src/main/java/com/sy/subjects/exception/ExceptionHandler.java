package com.sy.subjects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorMessage> subjectNotFoundException(SubjectNotFoundException exception) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(message.getStatus())
                .body(message);
    }
}
