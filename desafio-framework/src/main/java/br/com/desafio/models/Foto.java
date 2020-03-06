package br.com.desafio.models;

import java.io.Serializable;

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
@Table(name = "tb_foto")
public class Foto implements Serializable{

	private static final long serialVersionUID = -1806602431048963649L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	private byte[] foto;

}
