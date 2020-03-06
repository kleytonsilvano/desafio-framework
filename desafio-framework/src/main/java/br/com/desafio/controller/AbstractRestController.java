package br.com.desafio.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.desafio.models.Usuario;
import br.com.desafio.repository.UsuarioRepository;

@RestController
@RequestMapping("/desafio")
public abstract class AbstractRestController {
	
	@Autowired
	private UsuarioRepository repository;

	protected Usuario getUsuario() {
		
		return repository.findByLogin(getLogin());
		
	}
	
	protected String getLogin() {
		
		return getRequest().getParameter("usuario");
		
	}
	
	private HttpServletRequest getRequest() {
		
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
                .getRequest();
	}
	
	


}
