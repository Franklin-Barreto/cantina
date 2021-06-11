package cantina;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import com.santander.cantina.dao.ClienteDao;
import com.santander.cantina.modelo.Cliente;
import com.santander.cantina.modelo.Endereco;
import com.santander.cantina.modelo.RelatorioPorClienteValorTotalPedido;
import com.santander.cantina.util.JpaUtil;

public class ClienteTest {

	private EntityManager em = JpaUtil.getEntityManager();
	private ClienteDao clienteDao = new ClienteDao(em);

	@Test
	void salvarCliente() {
		Cliente joao = new Cliente("João", "12346547987", LocalDate.of(1985, Month.SEPTEMBER, 20));
		joao.adicionaEndereco(new Endereco("sei la", "123", "São Paulo"));
		em.getTransaction().begin();
		em.persist(joao);
		em.getTransaction().commit();

		Cliente joaoSalvo = em.find(Cliente.class, 4);

		assertEquals(4, joao.getId());
		assertEquals(1, joaoSalvo.getEnderecos().size());
	}

	@Test
	void buscarClientesValorTotalCompraPorDataTestAT() {
		List<Object[]> compraPorData = clienteDao.buscarClientesValorTotalCompraPorDataAT();

		for (Object[] objects : compraPorData) {
			System.out.println(Arrays.toString(objects));
		}

		Object[] object = compraPorData.get(0);
		assertEquals(6, compraPorData.size());
		assertEquals(44.00, ((BigDecimal) object[1]).doubleValue());
	}

	@Test
	void buscarClientesValorTotalCompraPorDataTest() {
		List<RelatorioPorClienteValorTotalPedido> compraPorData = clienteDao.buscarClientesValorTotalCompraPorData();

		assertEquals(6, compraPorData.size());
		assertEquals(44.00, compraPorData.get(0).getValor().doubleValue());
	}
	
	@Test
	void buscaClientePorNomeECpf() {
		List<Cliente> clientes = clienteDao.buscarClientes("Luciane", "12345678912");
		assertEquals(1, clientes.size());
		assertEquals("Luciane", clientes.get(0).getNome());
	}

}
