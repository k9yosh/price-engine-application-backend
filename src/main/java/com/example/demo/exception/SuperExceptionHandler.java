package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class to handle custom Exceptions
 *
 * @author YomalM
 */

@ControllerAdvice
public class SuperExceptionHandler {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public void handleNotFoundExceptions(HttpServletResponse response, ProductNotFoundException exception) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(),exception.getMessage());
    }
}
