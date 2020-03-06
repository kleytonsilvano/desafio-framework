package br.com.desafio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albuns")
public class AlbumRestController extends AbstractRestController {

	
	
}
//Permitir a criação de álbuns de fotos. As fotos dos álbuns poderão ser visíveis a 
// todos os usuários. Apenas o dono de um álbum poderá excluí-lo.
