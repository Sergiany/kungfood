package br.com.kungFood.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import br.com.kungFood.model.PessoaModel;
import br.com.kungFood.repository.PessoaRepository;
import br.com.kungFood.uteis.Uteis;
 
@Named(value="PessoaController")
@ViewScoped
public class PessoaController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private PessoaModel pessoaModel;
 
	@Produces 
	private List<PessoaModel> pessoas;

 
	@Inject transient
	private PessoaRepository pessoaRepository;
 

	public List<PessoaModel> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<PessoaModel> pessoas) {
		this.pessoas = pessoas;
	}	
	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}
	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}
	/***
	 * CARREGA AS PESSOAS NA INICIALIZACAO 
	 */
	@PostConstruct
	public void init(){
 
		//RETORNAR AS PESSOAS CADASTRADAS
		this.pessoas = pessoaRepository.getPessoas();
	}
 
	/***
	 * CARREGA INFORMACOES DE UMA PESSOA PARA SER EDITADA
	 * @param pessoaModel
	 */
	public void editar(PessoaModel pessoaModel){
 
		/*PEGA APENAS A PRIMEIRA LETRA DO SEXO PARA SETAR NO CAMPO(M OU F)*/
		pessoaModel.setSexo(pessoaModel.getSexo().substring(0, 1));
 
		this.pessoaModel = pessoaModel;
 
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */

	public void alterar() throws ParseException {
 
		this.pessoaRepository.alterar(this.pessoaModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param pessoaModel
	 */

	public void excluir(PessoaModel pessoaModel){
 
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.pessoaRepository.excluir(pessoaModel.getCodigo());
 
		//REMOVENDO A PESSOA DA LISTA
		//ASSIM QUE A PESSOA EH REMOVIDA DA LISTA O DATATABLE ATUALIZADO
		this.pessoas.remove(pessoaModel);
 
	} 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */

	public void salvar(){
 
		pessoaRepository.salvar(this.pessoaModel);
 
		this.pessoaModel = null;
 
		Uteis.mensagemInfo("Registro cadastrado com sucesso");
 
	}
}
