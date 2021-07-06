package cantina;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.santander.cantina.dao.AvaliacaoProdutoDao;
import com.santander.cantina.dao.ClienteDao;
import com.santander.cantina.dao.ProdutoDao;
import com.santander.cantina.modelo.AvaliacaoProduto;
import com.santander.cantina.modelo.Cliente;
import com.santander.cantina.modelo.Produto;
import com.santander.cantina.util.JpaUtil;

class AvaliacaoProdutoTest {

	private EntityManager em = JpaUtil.getEntityManager();
	private ClienteDao clienteDao;
	private ProdutoDao produtoDao;
	private AvaliacaoProdutoDao avaliacaoProdutoDao;
	
	@BeforeEach
	void inicia() {
		clienteDao = new ClienteDao(em);
		produtoDao = new ProdutoDao(em);
		avaliacaoProdutoDao = new AvaliacaoProdutoDao(em);
	}
	
	@Test
	void avaliaProduto() {
		Cliente cliente = clienteDao.buscarPorId(2);
		Produto produto = produtoDao.buscarPorId(1);
		AvaliacaoProduto avaliacaoProduto = new AvaliacaoProduto(cliente , produto , 5, "Porcaria de produto serve nem pra rato comer");
		avaliacaoProdutoDao.avalia(avaliacaoProduto);
	//	AvaliacaoProduto avaliacao = avaliacaoProdutoDao.buscarPorId(cliente.getId(), produto.getId());
		
	//	assertEquals(5, avaliacao.getNota());
		
	}
}
