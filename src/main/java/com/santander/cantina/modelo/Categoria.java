package com.santander.cantina.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	public Categoria(String nome) {
		this.nome = nome;
	}
	
	protected Categoria() {}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
