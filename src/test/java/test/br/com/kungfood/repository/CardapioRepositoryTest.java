package test.br.com.kungfood.repository;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.kungFood.model.CardapioModel;
import br.com.kungFood.repository.CardapioRepository;

public class CardapioRepositoryTest {

	CardapioRepository dao;
	CardapioModel cardapioModel;
	
	@Before
	public void setUp() throws Exception {
		dao = new CardapioRepository();
		cardapioModel = new CardapioModel();
		
		cardapioModel.setNm_prato("cheese");
		cardapioModel.setDs_prato("cheese");
		cardapioModel.setVl_prato(2.50);

	}

	@After
	public void tearDown() throws Exception {
		// dao.excluir(cardapioModel.getId_prato());
		dao = null;
	}

	//@Test
	public void testSalvar() throws ParseException {
		dao.salvarNovoProduto(cardapioModel);
		
		//List<CardapioModel> cardapios = dao.getCardapio();

		//assertNotNull("t01", cardapios);
		
		//int tamanho = cardapios.size();
		//System.out.println("Tamanho: " + tamanho);

	

//		assertEquals("t01", 1, cardapios.size());
//		
//		// CardapioModel pm = cardapios.get(0);
//		
		
		dao.excluir(cardapioModel.getId_prato());
	}
	
	//@Test
	public void testGetCardapio() throws ParseException {
		dao.salvarNovoProduto(cardapioModel);
		
		List<CardapioModel> produtos = dao.getCardapio();

		assertNotNull("T02", produtos);

		int tamanho = produtos.size();
		System.out.println("Tamanho: " + tamanho);

		// Inserir um Produto

		/*produtos = dao.getCardapio();

		assertEquals("t02", tamanho, produtos.size());	
		dao.excluir(cardapioModel.getId_prato());*/

	}

	//@Test
	public void testAlterar() throws ParseException {
		dao.salvarNovoProduto(cardapioModel);
		
		dao.alterarRegistro(cardapioModel);
		
		List<CardapioModel> produtos = dao.getCardapio();
		CardapioModel pm = produtos.get(0);
		assertEquals("t02", "cheese", pm.getNm_prato());
		assertNotSame("t03", produtos.size(), pm.getId_prato());
		
		dao.excluir(cardapioModel.getId_prato());
		
	}

	@Test
	public void testExcluir() throws ParseException {
		dao.salvarNovoProduto(cardapioModel);
		
		dao.excluir(cardapioModel.getId_prato());
		dao = null;
		
	}
}
