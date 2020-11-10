package br.com.desafio.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;

import br.com.desafio.exceptions.PermissaoNegadaException;

//@Component
public class JWTFilter extends OncePerRequestFilter {

	private static final String BEARER = "Bearer ";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		String tokenJWT = request.getHeader("Authorization");

		if (tokenJWT == null || !tokenJWT.startsWith(BEARER) || isTokenExpired(tokenJWT)) {
			throw new PermissaoNegadaException();
		}

		tokenJWT = tokenJWT.replace(BEARER, "");
		String usuario = JWT.decode(tokenJWT)
				.getSubject();

		request.setAttribute("usuario", usuario);

		chain.doFilter(request, response);
	}


	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public Date getExpirationDateFromToken(String token) {
		return JWT.decode(token)
				.getExpiresAt();
	}

}