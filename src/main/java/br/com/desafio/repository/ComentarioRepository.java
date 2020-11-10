package br.com.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.models.Comentario;
import br.com.desafio.models.Post;
import br.com.desafio.models.Usuario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Post> findByPost_Id(Long id);

    boolean existsByUsuarioAndId(Usuario usuario, Long id);

}
