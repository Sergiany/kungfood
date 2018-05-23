package test.br.com.kungfood.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.kungFood.model.PessoaModel;
import br.com.kungFood.repository.PessoaRepository;

public class PessoaRepositoryTest {
	
	PessoaRepository dao;
	PessoaModel pessoaModel;

	@Before
	public void setUp() throws Exception {
		dao = new PessoaRepository();
		pessoaModel = new PessoaModel();
		pessoaModel.setNome("Xuxa");
		
	}

	@After
	public void tearDown() throws Exception {
		//dao.ExcluirRegistro(pessoaModel.getCodigo());
		dao = null;
	}

	//@Test
	public void testSalvarNovoRegistro() {

		dao.salvarNovoRegistro(pessoaModel);
		
		List<PessoaModel> pessoas = dao.getPessoas();
		
		assertTrue("T01", pessoas.contains(pessoaModel));
		
	}

	//@Test
	public void testGetPessoas() {
		List<PessoaModel> pessoas = dao.getPessoas();
		
		assertNotNull("T01", pessoas);
		
		int tamanho = pessoas.size();
		
		//Inserir um pessoa
		
		pessoas = dao.getPessoas();
		
		assertEquals("T02", tamanho, pessoas.size());
	
	}

	//@Test
	public void testAlterarRegistro() {
		fail("Not yet implemented");
	}

	//@Test
	public void testExcluirRegistro() {
		fail("Not yet implemented");
	}

}