package com.santander.cantina.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.santander.cantina.modelo.Cliente;

public class ClienteDao {

	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public Cliente buscarPorId(Integer id) {
		return em.find(Cliente.class, id);
	}

	public List<Object[]> buscarClientesValorTotalCompraPorData() {

		String jpql = "SELECT p.cliente.nome,sum(p.valorTotal) "
				+ "FROM Pedido p GROUP BY p.cliente.id, MONTH(p.dataCriacao), YEAR(p.dataCriacao) ORDER BY p.cliente.id";

		return em.createQuery(jpql, Object[].class).getResultList();
	}

}
