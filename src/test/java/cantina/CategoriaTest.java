package cantina;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import com.santander.cantina.dao.CategoriaDao;
import com.santander.cantina.modelo.Categoria;
import com.santander.cantina.util.JpaUtil;

public class CategoriaTest {

	private EntityManager em =  JpaUtil.getEntityManager();
	private CategoriaDao dao = new CategoriaDao(em);

	@Test
	public void listarTodas() {
		List<Categoria> categorias = dao.listarTodas();
		assertEquals(3, categorias.size());
	}
}
