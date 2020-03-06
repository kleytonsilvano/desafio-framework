package br.com.desafio.exceptions;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PermissaoNegadaException.class)
    public void springHandlePermissaoNegada(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_GATEWAY.value());
    }

    @ExceptionHandler(NaoEncontradoException.class)
    public void springHandle404(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}
