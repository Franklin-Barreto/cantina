package cantina;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.santander.cantina.dao.ProdutoDao;
import com.santander.cantina.modelo.Produto;
import com.santander.cantina.util.JpaUtil;

public class ProdutoTest {

	private EntityManager em;
	private ProdutoDao produtoDao;

	@BeforeEach
	void inicializar() {
		em = JpaUtil.getEntityManager();
		produtoDao = new ProdutoDao(em);
	}

	@Test
	void buscarProdutoPorNome() {
		List<Produto> produtos = produtoDao.buscarProdutosPorNome("c");
		assertEquals(2, produtos.size());
		assertEquals("coca-cola", produtos.get(0).getNome());
	}

	@Test
	void buscarProdutoPorNomeECategoria() {
		List<Produto> produtos = produtoDao.buscarProdutosPorNomeECategoria("coca", "bebidas");
		assertEquals(1, produtos.size());
		assertEquals("coca-cola", produtos.get(0).getNome());
	}

	@Test
	void buscarProdutoPorNomeECategoriaNULL() {
		List<Produto> produtos = produtoDao.buscarProdutosPorNomeECategoria("coca", null);
		assertEquals(1, produtos.size());
		assertEquals("coca-cola", produtos.get(0).getNome());
	}
}
