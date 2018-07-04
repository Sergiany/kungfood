package test.br.com.kungfood.repository;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.time.LocalDateTime;
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
		pessoaModel.setEmail("xuxa@xuxa.com");
		pessoaModel.setEndereco("jvt");
		pessoaModel.setSexo("feminino");
		//pessoaModel.setDataCadastro(LocalDateTime.now());
		
		
	}

	@After
	public void tearDown() throws Exception {
		//dao.excluir(pessoaModel.getCodigo());
		dao = null;
	}

	//@Test
	public void testSalvar() {

		dao.salvar(pessoaModel);
		
		List<PessoaModel> pessoas = dao.getPessoas();
		
		assertNotNull("t1", pessoas);

		int tamanho = pessoas.size();
		System.out.println("Tamanho: " + tamanho);


		assertEquals("t02", 1, pessoas.size());
		
		PessoaModel pm = pessoas.get(0);
		
		assertEquals("t03", "xuxa", pm.getNome());
		assertEquals("t04", "xuxa@xuxa.com", pm.getEmail());
		assertEquals("t05", "jvt", pm.getEndereco());
		assertEquals("t06", LocalDateTime.now(), pm.getDataCadastro());
		assertEquals("t07", "feminino", pm.getSexo());
		
	}

	//@Test
	public void testGetPessoas() {
		dao.salvar(pessoaModel);
		
		List<PessoaModel> pessoas = dao.getPessoas();
		
		assertNotNull("T01", pessoas);
		
		int tamanho = pessoas.size();
		System.out.println("Tamanho: " + tamanho);
		
		//Inserir um pessoa
		
		pessoas = dao.getPessoas();
		
		assertEquals("T02", tamanho, pessoas.size());
		dao.excluir(pessoaModel.getCodigo());
	
	}

	//@Test
	public void testAlterarRegistro() throws ParseException {
		dao.salvar(pessoaModel);
		
		dao.alterar(pessoaModel);
		
		List<PessoaModel> pessoas = dao.getPessoas();
		PessoaModel pm = pessoas.get(0);
		assertNotSame("t03", pessoas.size(), pessoaModel.getCodigo());
		assertEquals("t04", "xuxa", pm.getNome());
		dao.excluir(pessoaModel.getCodigo());
	}

	//@Test
	public void testExcluirRegistro() {
		dao.salvar(pessoaModel);
		
		dao.excluir(pessoaModel.getCodigo());
		dao = null;
	}

}