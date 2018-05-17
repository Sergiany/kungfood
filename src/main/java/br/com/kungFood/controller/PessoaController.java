package br.com.kungFood.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;

import br.com.kungFood.model.PessoaModel;
import br.com.kungFood.repository.PessoaRepository;
import br.com.kungFood.uteis.Uteis;
 
@Named(value="PessoaController")
@ViewScoped
public class PessoaController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private PessoaModel pessoaModel;
	
	@Inject transient
	private UsuarioController usuarioController;
 
	@Produces 
	private List<PessoaModel> pessoas;
 
	@Inject transient
	private PessoaRepository pessoaRepository;
 
	@Test
	public List<PessoaModel> getPessoas() {
		return pessoas;
	}
	@Test
	public void setPessoas(List<PessoaModel> pessoas) {
		this.pessoas = pessoas;
	}	
	@Test
	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}
	@Test
	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}
 
	/***
	 * CARREGA AS PESSOAS NA INICIALIZACAO 
	 */
	@PostConstruct
	@Test
	public void init(){
 
		//RETORNAR AS PESSOAS CADASTRADAS
		this.pessoas = pessoaRepository.getPessoas();
	}
 
	/***
	 * CARREGA INFORMACOES DE UMA PESSOA PARA SER EDITADA
	 * @param pessoaModel
	 */
	@Test
	public void editar(PessoaModel pessoaModel){
 
		/*PEGA APENAS A PRIMEIRA LETRA DO SEXO PARA SETAR NO CAMPO(M OU F)*/
		pessoaModel.setSexo(pessoaModel.getSexo().substring(0, 1));
 
		this.pessoaModel = pessoaModel;
 
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	@Test
	public void alterarRegistro(){
 
		this.pessoaRepository.alterarRegistro(this.pessoaModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param pessoaModel
	 */
	@Test
	public void excluirPessoa(PessoaModel pessoaModel){
 
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.pessoaRepository.excluirRegistro(pessoaModel.getCodigo());
 
		//REMOVENDO A PESSOA DA LISTA
		//ASSIM QUE A PESSOA EH REMOVIDA DA LISTA O DATATABLE ATUALIZADO
		this.pessoas.remove(pessoaModel);
 
	} 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	@Test
	public void salvarNovaPessoa(){
 
		pessoaModel.setUsuarioModel(this.usuarioController.getUsuarioSession());
 
		//INFORMANDO QUE O CADASTRO FOI VIA INPUT
		pessoaModel.setOrigemCadastro("I");
 
		pessoaRepository.salvarNovoRegistro(this.pessoaModel);
 
		this.pessoaModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
}
