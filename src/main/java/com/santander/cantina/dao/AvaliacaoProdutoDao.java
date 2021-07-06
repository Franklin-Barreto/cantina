package com.santander.cantina.dao;

import javax.persistence.EntityManager;

import com.santander.cantina.modelo.AvaliacaoChave;
import com.santander.cantina.modelo.AvaliacaoProduto;

public class AvaliacaoProdutoDao {

	private EntityManager em;

	public AvaliacaoProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void avalia(AvaliacaoProduto avaliacaoProduto) {
		em.persist(avaliacaoProduto);
	}

	public AvaliacaoProduto buscarPorId(int clienteId, int produtoId) {
		return em.find(AvaliacaoProduto.class, new AvaliacaoChave(clienteId, produtoId));
	}

}
