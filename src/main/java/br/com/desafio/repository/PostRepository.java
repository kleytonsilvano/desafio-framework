package br.com.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.models.Post;
import br.com.desafio.models.Usuario;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUsuario(Usuario usuario);

    boolean existsByUsuarioAndId(Usuario usuario, Long id);

}