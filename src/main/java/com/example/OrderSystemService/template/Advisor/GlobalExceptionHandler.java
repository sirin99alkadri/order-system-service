package com.example.OrderSystemService.template.Advisor;

import com.example.OrderSystemService.Base.API.Response.CAPIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CAPIResponse handleValidationExceptions(MethodArgumentNotValidException ex) {

        StringBuilder message = new StringBuilder();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            message.append(error.getField())
                    .append(" ")
                    .append(error.getDefaultMessage())
                    .append(", ");
        });

        log.warn("Validation failed: {}", message);

        return new CAPIResponse()
                .setStatus(HttpStatus.BAD_REQUEST)
                .setErrorMessage(message.toString());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public CAPIResponse handleNullPointerEx(NullPointerException ex) {

        log.warn("Null pointer exception: {}", ex.getMessage());

        return new CAPIResponse()
                .setStatus(HttpStatus.BAD_REQUEST)
                .setErrorMessage("Unexpected internal error: " + ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public CAPIResponse handleIllegalArg(IllegalArgumentException ex) {
        return new CAPIResponse()
                .setStatus(HttpStatus.BAD_REQUEST)
                .setErrorMessage("Incorrect data: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CAPIResponse handleGlobalException(Exception ex) {
        return new CAPIResponse()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setErrorMessage("Something went wrong on our side: " + ex.getMessage());
    }

}