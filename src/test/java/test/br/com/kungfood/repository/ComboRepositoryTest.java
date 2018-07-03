package test.br.com.kungfood.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import br.com.kungFood.model.ComboModel;
import br.com.kungFood.repository.ComboRepository;


public class ComboRepositoryTest {

	ComboRepository dao;
	ComboModel comboModel;
	
	@Before
	public void setUP() throws Exception {
	
		dao = new ComboRepository();
		comboModel = new ComboModel();
		
		comboModel.setNm_combo("dd");
		comboModel.setDs_combo("dd");
		comboModel.setVl_combo(13.00);

	}
	
	@After
	public void tearDown() throws Exception {
		dao = null;
	}
	
	@Test
	public void testSalvarCombo() {
		
		dao.salvarNovoCombo(comboModel);
		List<ComboModel> combo = dao.getCombo();
		
			assertNotNull("T02", combo);
		
		int tamanho = combo.size();
		System.out.println("Tamanho: " + tamanho);
		
			assertTrue("T02", combo.contains(comboModel));

		dao.excluir(comboModel.getId_combo());
		assertEquals("t01", tamanho, combo.size());
				
		ComboModel cm = combo.get(0);
		
		assertEquals("t02", "asdw", cm.getDs_combo());
		assertEquals("t03", "uerli", cm.getNm_combo());
		assertEquals("t06", new Double(0.99), new Double(cm.getVl_combo()));
		
			dao.excluir(comboModel.getId_combo());
	}
	
	@Test
	public void testGetCombo() {
		dao.salvarNovoCombo(comboModel);
		
		List<ComboModel> combo = dao.getCombo();

		assertNotNull("T02", combo);

		int tamanho = combo.size();
		System.out.println("Tamanho: " + tamanho);

		// Inserir um Produto

		combo = dao.getCombo();

		assertEquals("T02", tamanho, combo.size());	
		dao.excluir(comboModel.getId_combo());
	}

	@Test
	public void testAlterar()  throws ParseException {
		dao.salvarNovoCombo(comboModel);
		
		dao.alterarRegistro(comboModel);
		
		List<ComboModel> combo = dao.getCombo();
		ComboModel cm = combo.get(0);
		assertNotSame("t03", combo.size(), comboModel.getId_combo());
//		assertEquals("T02", "asdw", cm.getDs_combo());
		
	}

	@Test
	public void testExcluir() {
		dao.salvarNovoCombo(comboModel);
		
		dao.excluir(comboModel.getId_combo());
		dao = null;
		
	}
	
}
