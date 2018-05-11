package br.com.kungFood.pessoa.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;

import br.com.kungFood.model.PessoaModel;
import br.com.kungFood.repository.PessoaRepository;
import br.com.kungFood.usuario.controlle.UsuarioController;
import br.com.kungFood.uteis.Uteis;
 
@Named(value="cadastrarPessoaController")
@RequestScoped
public class CadastrarPessoaController {
 
	@Inject
	PessoaModel pessoaModel;
 
	@Inject
	UsuarioController usuarioController;
 
	@Inject
	PessoaRepository pessoaRepository;
 
 
	@Test
	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}
 
	@Test
	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	@Test
	public void SalvarNovaPessoa(){
 
		pessoaModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());
 
		//INFORMANDO QUE O CADASTRO FOI VIA INPUT
		pessoaModel.setOrigemCadastro("I");
 
		pessoaRepository.SalvarNovoRegistro(this.pessoaModel);
 
		this.pessoaModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
 
}