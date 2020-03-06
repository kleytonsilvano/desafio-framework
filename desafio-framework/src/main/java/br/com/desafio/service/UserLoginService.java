package br.com.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.desafio.exceptions.NaoEncontradoException;
import br.com.desafio.models.Usuario;
import br.com.desafio.repository.UsuarioRepository;

@Component
public class UserLoginService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = repository.findByLogin(username);
        if (usuario == null){
            throw new NaoEncontradoException();
        }
        return new org.springframework.security.core.userdetails.User(
        		usuario.getLogin(),
        		usuario.getSenha(),
                AuthorityUtils.createAuthorityList(""));
    }
}