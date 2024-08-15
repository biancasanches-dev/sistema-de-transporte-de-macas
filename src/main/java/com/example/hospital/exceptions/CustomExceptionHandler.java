package com.example.hospital.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.nio.file.AccessDeniedException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView handleNoSuchElementException(NoSuchElementException e) {
        String message = "Elemento não encontrado ";
        logger.error(message, e);

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", message);

        return modelAndView;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleIllegalArgumentException(IllegalArgumentException e) {
        String message = "Argumento inválido ";
        logger.error(message, e);

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", message);

        return modelAndView;
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ModelAndView handleNoResourceFoundException(NoResourceFoundException e) {
        String message = "Recurso não encontrado";
        logger.error(message, e);

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", message);

        return modelAndView;
    }

    @ExceptionHandler(DataAccessException.class)
    public ModelAndView handleDataAccessException(DataAccessException e) {
        String message = "Erro ao acessar o banco de dados! Tente novamente. ";
        logger.error(message, e);

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", message);

        return modelAndView;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView handleAccessDeniedException(AccessDeniedException e) {
        String message = "Acesso negado! ";
        logger.error(message, e);

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", message);

        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        String message = "Aconteceu um erro inesperado! ";
        logger.error(message, e);

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", message);

        return modelAndView;
    }

}
