package br.com.desafio.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 5722841298403053734L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
	private String nome;

    @Column
	private String senha;

    @Column
	private String login;

}
