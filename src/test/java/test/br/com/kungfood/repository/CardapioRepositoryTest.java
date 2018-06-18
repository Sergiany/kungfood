package test.br.com.kungfood.repository;

import static org.junit.Assert.*;

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

	}

	@After
	public void tearDown() throws Exception {
		dao.excluir(cardapioModel.getId_prato());
		dao = null;
	}

	@Test
	public void testSalvar() {
		dao.salvarNovoProduto(cardapioModel);
		
		List<CardapioModel> cardapios = dao.getCardapio();

	
		
		int tamanho = cardapios.size();
		System.out.println("Tamanho: " + tamanho);

	

		assertEquals("t01", 1, cardapios.size());
		
		// CardapioModel pm = cardapios.get(0);
		
		
		dao.excluir(cardapioModel.getId_prato());
	}
	
	//@Test
	public void testGetCardapio() {
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
	public void testAlterar() {
		/*dao.salvarNovoProduto(cardapioModel);
		
		dao.alterarRegistro(cardapioModel);
		
		List<CardapioModel> produtos = dao.getCardapio();
		ProdutoModel pm = produtos.get(0);
		assertNotSame("t03", produtos.size(), cardapioModel.getId_produto());
		assertEquals("t02", "pratos", pm.getDs_produto());
		*/
	}

	@Test
	public void testExcluir() {
		/*dao.salvar(produtoModel);
		
		dao.excluir(produtoModel.getId_produto());
		dao = null;*/
		
	}
}
