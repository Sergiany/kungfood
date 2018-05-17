package br.com.kungFood.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;

import br.com.kungFood.model.CardapioModel;
import br.com.kungFood.repository.CardapioRepository;
import br.com.kungFood.uteis.Uteis;

@Named(value="CardapioController")
@ViewScoped
public class CardapioController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject transient
	private CardapioModel cardapioModel;
	
	@Produces
	private List<CardapioModel> cardapios;
	
	@Inject transient
	private CardapioRepository cardapioRepository;
	
	@Test
	public List<CardapioModel> getCardapios(){
		return cardapios;
	}
	
	@Test
	public void setCardapios(List<CardapioModel> cardapios) {
		this.cardapios = cardapios;
	}
	
	@Test
	public CardapioModel getCardapioModel(){
		return cardapioModel;
	}
	
	@Test
	public void setCardapioModel(CardapioModel cardapioModel) {
		this.cardapioModel = cardapioModel;
	}
	
	/***
	 * CARREGA OS PRATOS NA INICIALIZACAO 
	 */
	@PostConstruct
	@Test
	public void init(){
		
		//Retorna os pratos cadastrados
		this.cardapios = cardapioRepository.getCardapio();
	}
	
	/***
	 * CARREGA INFORMACOES DE UM PRATO PARA SER EDITADO
	 * @param  cardapioModel
	 */
	@Test
	public void editar(CardapioModel cardapioModel){
		
		this.cardapioModel = cardapioModel;
	}
	
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	@Test
	public void alterarRegistro(){
		
		this.cardapioRepository.alterarRegistro(this.cardapioModel);
		
		//recarrega registros
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param cardapioModel
	 */
	@Test
	public void excluirCardapio(CardapioModel cardapioModel){
		
		//exclui o prato do banco de dados
		this.cardapioRepository.excluirRegistro(cardapioModel.getId_prato());
		
		this.cardapios.remove(cardapioModel);
	}
	
	@Test
	public void salvarNovoCardapio(){
		
		cardapioRepository.salvarNovoProduto(this.cardapioModel);
		
		this.cardapioModel = null;
		
		Uteis.MensagemInfo("Prato cadastrado com sucesso");
	}
}
