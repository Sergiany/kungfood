package br.com.kungFood.pessoa.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;

import br.com.kungFood.model.CardapioModel;
import br.com.kungFood.repository.CardapioRepository;
import br.com.kungFood.uteis.Uteis;

@Named (value = "cadastrarCardapioController")
@RequestScoped
public class CadastrarCardapioController {
	
	@Inject
	CardapioModel cardapioModel;
	
	@Inject
	CardapioRepository cardapioRepository;
	
	@Test
	public CardapioModel getCardapioModel(){
		return cardapioModel;
	}
	@Test
	public void setCardapioModel(CardapioModel cardapioModel) {
		this.cardapioModel = cardapioModel;
	}
	
	
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	@Test
	public void SalvarNovoCardapio(){
		
		cardapioRepository.SalvarNovoProduto(this.cardapioModel);
		
		this.cardapioModel = null;
		
		Uteis.MensagemInfo("Prato cadastrado com sucesso");
	}
}
