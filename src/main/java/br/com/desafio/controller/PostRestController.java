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
import br.com.desafio.models.Post;
import br.com.desafio.repository.PostRepository;

@RestController
@RequestMapping("/posts")
public class PostRestController extends AbstractRestController {

    @Autowired
    private PostRepository repository;
    
	@GetMapping
	public List<Post> listarPosts() {
		return repository.findByUsuario(getUsuario());
	}
	
	@PostMapping
	public void cadastrarPosts(@RequestBody Post post) {
		post.setUsuario(getUsuario());
		repository.save(post);
	}
	
	@DeleteMapping
	public void deletarPosts(@RequestHeader(value = "id-post") Long id) {
		
		if(repository.existsByUsuarioAndId(getUsuario(), id)) {
			
			repository.deleteById(id);
			
		}
		
		new PermissaoNegadaException();
		
	}
}