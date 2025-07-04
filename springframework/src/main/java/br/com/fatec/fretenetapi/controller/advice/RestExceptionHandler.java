package br.com.fatec.fretenetapi.controller.advice;

import br.com.fatec.fretenetapi.controller.dto.response.ErrorResponse;
import br.com.fatec.fretenetapi.exception.BadRequestException;
import br.com.fatec.fretenetapi.exception.InternalServerException;
import br.com.fatec.fretenetapi.exception.NotFoundException;
import br.com.fatec.fretenetapi.exception.UnprocessableEntityException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseBody
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler({InternalServerException.class, Exception.class})
    public ErrorResponse handleInternalServerError(
            Exception exception,
            HttpServletRequest request) {
        return new ErrorResponse(
                LocalDateTime.now(),
                request.getServletPath(),
                INTERNAL_SERVER_ERROR.value(),
                INTERNAL_SERVER_ERROR.getReasonPhrase(),
                exception.getMessage());
    }

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFoundError(
            NotFoundException exception,
            HttpServletRequest request) {
        System.out.println("HANDLE ERROR ON NOTFOUND");
        return new ErrorResponse(
                LocalDateTime.now(),
                request.getServletPath(),
                NOT_FOUND.value(),
                NOT_FOUND.getReasonPhrase(),
                exception.getMessage());
    }

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorResponse handleBadRequest(
            BadRequestException exception,
            HttpServletRequest request) {
        return new ErrorResponse(
                LocalDateTime.now(),
                request.getServletPath(),
                BAD_REQUEST.value(),
                BAD_REQUEST.getReasonPhrase(),
                exception.getMessage());
    }

    @ResponseBody
    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ExceptionHandler(UnprocessableEntityException.class)
    public ErrorResponse handleUnprocessableEntity(
            UnprocessableEntityException exception,
            HttpServletRequest request) {
        return new ErrorResponse(
                LocalDateTime.now(),
                request.getServletPath(),
                UNPROCESSABLE_ENTITY.value(),
                UNPROCESSABLE_ENTITY.getReasonPhrase(),
                exception.getMessage());
    }
}