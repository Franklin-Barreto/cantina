package com.santander.cantina.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.santander.cantina.modelo.Cliente;
import com.santander.cantina.modelo.RelatorioPorClienteValorTotalPedido;

public class ClienteDao {

	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public Cliente buscarPorId(Integer id) {
		return em.find(Cliente.class, id);
	}

	public List<Object[]> buscarClientesValorTotalCompraPorDataAT() {

		String jpql = "SELECT p.cliente.nome,sum(p.valorTotal) "
				+ "FROM Pedido p GROUP BY p.cliente.id, MONTH(p.dataCriacao), YEAR(p.dataCriacao) ORDER BY p.cliente.id";

		return em.createQuery(jpql, Object[].class).getResultList();
	}

	public List<RelatorioPorClienteValorTotalPedido> buscarClientesValorTotalCompraPorData() {

		String jpql = "SELECT new com.santander.cantina.modelo.RelatorioPorClienteValorTotalPedido("
				+ "p.cliente.nome,sum(p.valorTotal)) "
				+ "FROM Pedido p GROUP BY p.cliente.id, MONTH(p.dataCriacao), YEAR(p.dataCriacao) ORDER BY p.cliente.id";

		return em.createQuery(jpql, RelatorioPorClienteValorTotalPedido.class).getResultList();
	}

	public List<Cliente> buscarClientes(String nome, String cpf) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
		Root<Cliente> root = cq.from(Cliente.class);

		List<Predicate> predicates = new ArrayList<Predicate>();
		Predicate[] predicate = new Predicate[2];
		
		 Predicate filtro = cb.and();
		
		if (nome != null) {
			//predicates.add(cb.equal(root.get("nome"), nome));
			
			filtro = cb.and(filtro,cb.equal(root.get("nome"), nome));
		}

		if (cpf != null) {
			//predicates.add(cb.like(root.get("cpf"), "%" + cpf + "%"));
			filtro = cb.and(filtro,cb.like(root.get("cpf"), "%" + cpf + "%"));
		}

		;
		//cq.select(root).where(predicates.toArray(Predicate[]::new));
		cq.select(root).where(filtro);

		return em.createQuery(cq).getResultList();

	}

}
