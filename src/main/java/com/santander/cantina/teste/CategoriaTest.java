package com.santander.cantina.teste;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;

import com.santander.cantina.dao.ClienteDao;
import com.santander.cantina.dao.ProdutoDao;
import com.santander.cantina.modelo.Cliente;
import com.santander.cantina.modelo.Endereco;
import com.santander.cantina.modelo.ProdutoMaisVendido;
import com.santander.cantina.util.JpaUtil;

public class CategoriaTest {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();

		Cliente joao = new Cliente("Jo�o", "12346547987", LocalDate.of(1985, Month.SEPTEMBER, 20));
		Endereco endereco = new Endereco("sei la", "123", "S�o Paulo");
	
		Cliente joaoSalvo = em.find(Cliente.class, 1);

		System.out.println(joaoSalvo.getEnderecos().size());
		
		ClienteDao clienteDao = new ClienteDao(em);
		
		ProdutoMaisVendido produto = new ProdutoDao(em).relatorio();
		
		System.out.println(produto.getNome());
		
	}
}
