package test.br.com.kungfood.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.text.ParseException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.kungFood.model.ProdutoModel;
import br.com.kungFood.repository.ProdutoRepository;

public class ProdutoRepositoryTest {

	ProdutoRepository dao;

	ProdutoModel produtoModel;

	@Before
	public void setUp() throws Exception {

		dao = new ProdutoRepository();
		produtoModel = new ProdutoModel();

		produtoModel.setDs_produto("pratos");
		produtoModel.setNm_produto("nome");
		produtoModel.setQt_produto(55);
		produtoModel.setValidade_produto("25/10/2015");
		produtoModel.setVl_produto(25.5);

	}

	@After
	public void tearDown() throws Exception {
		//dao.excluir(produtoModel.getId_produto());
		dao = null;
	}

	@Test
	public void testSalvar() {

		dao.salvar(produtoModel);
		
		List<ProdutoModel> produtos = dao.findAll();

		//assertNotNull("T02", produtos);
		
		int tamanho = produtos.size();
		System.out.println("Tamanho: " + tamanho);

		//assertTrue("T02", produtos.contains(produtoModel));

		dao.excluir(produtoModel.getId_produto());
		assertEquals("t01", tamanho, produtos.size());
		
		ProdutoModel pm = produtos.get(0);
		
		assertEquals("t02", "asdw", pm.getDs_produto());
		assertEquals("t03", "uerli", pm.getNm_produto());
		assertEquals("t04", new Double(1.0), new Double(pm.getQt_produto()));
		assertEquals("t05", "20/06/2018", pm.getValidade_produto());
		assertEquals("t06", new Double(0.99), new Double(pm.getVl_produto()));
		// dao.excluir(produtoModel.getId_produto());
	}

	@Test
	public void testGetProduto() {
		dao.salvar(produtoModel);
		
		List<ProdutoModel> produtos = dao.getProdutos();

		assertNotNull("T02", produtos);

		int tamanho = produtos.size();
		System.out.println("Tamanho: " + tamanho);

		// Inserir um Produto

		produtos = dao.getProdutos();

		assertEquals("T02", tamanho, produtos.size());	
		dao.excluir(produtoModel.getId_produto());

	}

	@Test
	public void testAlterar()  throws ParseException {
		dao.salvar(produtoModel);
		
		dao.alterar(produtoModel);
		
		List<ProdutoModel> produtos = dao.getProdutos();
		ProdutoModel pm = produtos.get(0);
		assertNotSame("t03", produtos.size(), produtoModel.getId_produto());
		assertEquals("T02", "asdw", pm.getDs_produto());
		
	}

	@Test
	public void testExcluir() {
		dao.salvar(produtoModel);
		
		dao.excluir(produtoModel.getId_produto());
		dao = null;
		
	}

}