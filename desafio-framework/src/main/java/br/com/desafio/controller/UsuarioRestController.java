package br.com.desafio.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.desafio.exceptions.PermissaoNegadaException;
import br.com.desafio.models.Usuario;
import br.com.desafio.models.vo.TokenJWT;
import br.com.desafio.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {

	@Autowired
	private UsuarioRepository repository;

	@PostMapping
	public void cadastrarUsuario(@RequestBody Usuario usuario) {
		repository.save(usuario);
	}

	@GetMapping
	@RequestMapping("/logins")
	public TokenJWT login(@RequestHeader(value = "authorization") String authString) {

		try {

			String decodedAuth;
			String[] authParts = authString.split("\\s+");
			String authInfo = authParts[1];
			byte[] bytes = new Base64().decode(authInfo); 

			decodedAuth = new String(bytes);

			String login = decodedAuth.split(":")[0];
			String senha = decodedAuth.split(":")[1];

			if(repository.findByLoginAndSenha(login, senha) != null) {

				Date data = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
				String jwt = JWT.create()
		                .withClaim("uid", login)
		                .withExpiresAt(data)
		                .sign(Algorithm.HMAC256(""));
				TokenJWT tokenJWT = new TokenJWT();
				tokenJWT.setAccessToken(jwt);
				tokenJWT.setExpireIn(data.getTime());
				
				return tokenJWT;
				
			}


		}catch(Exception e) {

			throw new PermissaoNegadaException();

		}

		throw new PermissaoNegadaException();

	}

}