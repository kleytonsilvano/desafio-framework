package br.com.desafio.models.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenJWT {
	
	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("expire_in")
	private Long expireIn;
	

}
