package cantina;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import com.santander.cantina.modelo.Cliente;
import com.santander.cantina.modelo.ItemPedido;
import com.santander.cantina.modelo.Pedido;
import com.santander.cantina.modelo.Produto;
import com.santander.cantina.util.JpaUtil;

class PedidoTest {

	private EntityManager em = JpaUtil.getEntityManager();

	@Test
	void salvarPedido() {

		em.getTransaction().begin();
		List<Produto> produtos = em.createQuery("SELECT p FROM Produto p WHERE id in(1,2,3)", Produto.class)
				.getResultList();
		List<ItemPedido> itens = produtos.stream().map(p -> new ItemPedido(p, 2)).collect(Collectors.toList());
		Cliente cliente = em.find(Cliente.class, 3);
		Pedido pedido = new Pedido(cliente);

		itens.stream().forEach(item -> pedido.adicionaItem(item));
		em.persist(pedido);
		em.getTransaction().commit();
		
		assertEquals(7, pedido.getId());
	}
}
