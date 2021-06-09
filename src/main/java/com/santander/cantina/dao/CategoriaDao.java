package com.santander.cantina.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.santander.cantina.modelo.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public void salvar(Categoria categoria) {
		em.persist(categoria);
	}

	public void atualizar(Categoria categoria) {
		em.merge(categoria);
	}

	public void excluir(Categoria categoria) {
		em.remove(categoria);
	}

	public List<Categoria> listarTodas() {
		return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
	}
}
