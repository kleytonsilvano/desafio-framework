package br.com.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.exceptions.PermissaoNegadaException;
import br.com.desafio.models.Comentario;
import br.com.desafio.models.Post;
import br.com.desafio.repository.ComentarioRepository;

@RestController
@RequestMapping("/comentarios")
public class ComentarioRestController extends AbstractRestController {

    @Autowired
    private ComentarioRepository repository;

    @GetMapping
	public List<Post> listarComentariosPorPost(@RequestHeader(value = "id-post") Long id) {
		return repository.findByPost_Id(id);
	}
    
	@PostMapping
	public void cadastrarComentarios(@RequestBody Comentario comentario) {
		comentario.setUsuario(getUsuario());
		repository.save(comentario);
	}
	
	@DeleteMapping
	public void deletarPosts(@RequestHeader(value = "id-post") Long id) {
		
		if(repository.existsByUsuarioAndId(getUsuario(), id)) {
			
			repository.deleteById(id);
			
		}
		
		new PermissaoNegadaException();
		
	}
	
}
