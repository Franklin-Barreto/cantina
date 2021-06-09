package com.santander.cantina.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private BigDecimal preco;
	@ManyToOne
	@JoinColumn(name = "categoria_fk")
	private Categoria categoria;

	public Produto(String nome, BigDecimal preco, Categoria categoria) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
	}
	
	public Produto() {
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

}
