package com.santander.cantina.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.santander.cantina.modelo.Cliente;
import com.santander.cantina.modelo.TotalCompraMensalCliente;

public class ClienteDao {

	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public Cliente buscarPorId(Integer id) {
		return em.find(Cliente.class, id);
	}

	public List<TotalCompraMensalCliente> relatorio() {

		String jpql = "SELECT new com.santander.cantina.modelo."
				+ "TotalCompraMensalCliente(c.nome,sum(p.valorTotal),concat(year(p.dataCriacao),'-',month(p.dataCriacao)))"
				+ "FROM Pedido p JOIN p.cliente c GROUP BY c.id, concat(year(p.dataCriacao),'-',month(p.dataCriacao)) ORDER BY c.nome";
		return em.createQuery(jpql, TotalCompraMensalCliente.class).getResultList();

	}

}
