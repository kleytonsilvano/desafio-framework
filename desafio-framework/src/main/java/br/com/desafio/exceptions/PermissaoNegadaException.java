package br.com.desafio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class PermissaoNegadaException extends RuntimeException {

	private static final long serialVersionUID = 212697209758981840L;

}