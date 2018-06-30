package test.br.com.kungfood.repository;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.kungFood.model.PessoaModel;
import br.com.kungFood.model.UsuarioModel;
import br.com.kungFood.repository.PessoaRepository;

public class PessoaRepositoryTest {
	
	PessoaRepository dao;
	PessoaModel pessoaModel;
	UsuarioModel usuarioModel;
	

	@Before
	public void setUp() throws Exception {
		dao = new PessoaRepository();
		usuarioModel = new UsuarioModel();
		usuarioModel.setUsuario("admin");
		usuarioModel.setSenha("admin");
		
		pessoaModel = new PessoaModel();
		
		pessoaModel.setNome("Xuxa");
		pessoaModel.setEmail("xuxa@xuxa.com");
		pessoaModel.setEndereco("jvt");
		pessoaModel.setSexo("feminino");
		pessoaModel.setDataCadastro(LocalDateTime.now());
		pessoaModel.setUsuarioModel(usuarioModel);
		pessoaModel.setOrigemCadastro("I");
		
		
	}

	@After
	public void tearDown() throws Exception {
		dao.excluir(pessoaModel.getCodigo());
		dao = null;
	}

	@Test
	public void testSalvar() {

		dao.salvar(pessoaModel);
		
		List<PessoaModel> pessoas = dao.getPessoas();

		int tamanho = pessoas.size();
		System.out.println("Tamanho: " + tamanho);


		assertEquals("t01", 1, pessoas.size());
		
		PessoaModel pm = pessoas.get(0);
		
		assertEquals("t02", "xuxa", pm.getNome());
		assertEquals("t03", "xuxa@xuxa.com", pm.getEmail());
		assertEquals("t04", "jvt", pm.getEndereco());
		assertEquals("t05", LocalDateTime.now(), pm.getDataCadastro());
		assertEquals("t06", usuarioModel, pm.getUsuarioModel());
		assertEquals("t07", "Teste", pm.getOrigemCadastro());
		assertEquals("t08", "feminino", pm.getSexo());
		
	}

	@Test
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