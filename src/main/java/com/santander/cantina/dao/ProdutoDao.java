package com.santander.cantina.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	public List<Produto> buscarProdutosPorNome(String nome) {

		return em.createQuery("SELECT p FROM Produto p WHERE p.nome LIKE :nome", Produto.class)
				.setParameter("nome", "%" + nome + "%").getResultList();
	}

	public List<Produto> buscarProdutosPorNomeECategoria(String nome, String categoria) {

		String jpql = "SELECT p FROM Produto p WHERE 1=1";

		if (nome != null) {
			jpql += " AND p.nome LIKE :nome";
		}

		if (categoria != null) {
			jpql += " AND p.categoria.nome LIKE :categoria";
		}

		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
		if (nome != null) {
			query.setParameter("nome", "%" + nome + "%");
		}

		if (categoria != null) {
			query.setParameter("categoria", "%" + categoria + "%");
		}

		return query.getResultList();

	}

	public void salvar(Produto produto) {
		em.persist(produto);
	}
}
