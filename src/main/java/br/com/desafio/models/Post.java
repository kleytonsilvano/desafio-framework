package br.com.desafio.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_post")
public class Post implements Serializable{

	private static final long serialVersionUID = 1486835718387330076L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String texto;
	
	@ElementCollection
	private List<String> links;

	@ElementCollection
	private List<byte[]> imagens;

	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="TB_POST_COMENTARIOS",
	            joinColumns =        {@JoinColumn(name = "post")}, 
	            inverseJoinColumns = {@JoinColumn(name="comentario")})
	private List<Comentario> comentarios;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	
}
