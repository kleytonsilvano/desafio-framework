package br.com.desafio.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "tb_album")
public class Album implements Serializable{

	private static final long serialVersionUID = 7391829067250918330L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	private String nome;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="TB_FOTO_ALBUM",
	            joinColumns =        {@JoinColumn(name = "album")}, 
	            inverseJoinColumns = {@JoinColumn(name="foto")})
	private List<Foto> foto;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario")
	private Usuario usuario;
}
