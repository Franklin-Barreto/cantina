package com.santander.cantina.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.santander.cantina.modelo.Produto;
import com.santander.cantina.modelo.ProdutoMaisVendido;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public ProdutoMaisVendido relatorio() {

		String jpql = "SELECT new com.santander.cantina.modelo.ProdutoMaisVendido(p.nome,p.preco) "
				+ "FROM ItemPedido it JOIN it.produto p GROUP BY p.id ORDER BY SUM(quantidade) desc";
		return em.createQuery(jpql, ProdutoMaisVendido.class).setMaxResults(1).getSingleResult();
	}

	public List<Produto> porNomeECategoria(String produtoNome, String produtoCategoria) {
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome =:categoriaNome AND p.nome = :produtoNome";
		return em.createQuery(jpql, Produto.class).setParameter("categoriaNome", produtoCategoria)
				.setParameter("produtoNome", produtoNome).getResultList();
	}

	public void salvar(Produto produto) {
		em.persist(produto);
	}
}
