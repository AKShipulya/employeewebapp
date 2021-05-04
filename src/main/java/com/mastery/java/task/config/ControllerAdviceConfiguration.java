package com.mastery.java.task.config;

import com.mastery.java.task.dto.ErrorResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdviceConfiguration {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ErrorResponse processEmptyResultDataAccessException(EmptyResultDataAccessException e, HttpServletRequest request) {
        return new ErrorResponse(request.getMethod(), request.getRequestURI());
    }
}
