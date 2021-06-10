package cantina;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import com.santander.cantina.dao.ClienteDao;
import com.santander.cantina.modelo.Cliente;
import com.santander.cantina.modelo.Endereco;
import com.santander.cantina.modelo.TotalCompraCliente;
import com.santander.cantina.modelo.TotalCompraMensalCliente;
import com.santander.cantina.util.JpaUtil;

class ClienteTest {

	private EntityManager em = JpaUtil.getEntityManager();

	@Test
	void salvarCliente() {
		Cliente joao = new Cliente("Jo�o", "12346547987", LocalDate.of(1985, Month.SEPTEMBER, 20));
		joao.adicionaEndereco(new Endereco("sei la", "123", "S�o Paulo"));
		em.getTransaction().begin();
		em.persist(joao);
		em.getTransaction().commit();

		Cliente joaoSalvo = em.find(Cliente.class, 4);

		assertEquals(4, joao.getId());
		assertEquals(1, joaoSalvo.getEnderecos().size());
	}

	@Test
	void totalDespesaCliente() {

		String jpql = "SELECT new com.santander.cantina.modelo.TotalCompraCliente(c.nome,sum(p.valorTotal),c.cpf) "
				+ "FROM Pedido p JOIN p.cliente c GROUP BY p.cliente ORDER BY c.nome";
		List<TotalCompraCliente> relatorio = em.createQuery(jpql, TotalCompraCliente.class).getResultList();

		assertEquals(3, relatorio.size());
		assertEquals(68.00, relatorio.get(0).getTotal().doubleValue());

	}
	
	@Test
	void totalDespesaMensal() {
		ClienteDao clienteDao = new ClienteDao(em);
		
		List<TotalCompraMensalCliente> relatorio = clienteDao.relatorio();
		
		assertEquals(7, relatorio.size());
		assertEquals(10.00, relatorio.get(0).getValorTotal().doubleValue());
	}
}
