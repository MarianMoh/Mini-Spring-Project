package org.example.hibernatetest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView entityNotFoundException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("error-page", HttpStatus.NOT_FOUND);
        modelAndView.addObject("error_name", "Error 404");
        modelAndView.addObject("error_description", exception.getMessage());
        modelAndView.addObject("error_img", "404.gif");
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView serverError(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("error-page", HttpStatus.BAD_REQUEST);
        modelAndView.addObject("error_name", "Error 500");
        modelAndView.addObject("error_description", exception.getMessage());
        modelAndView.addObject("error_img", "500.gif");
        return modelAndView;
    }
}
