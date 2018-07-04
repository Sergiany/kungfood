package br.com.kungFood.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


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
	

	public List<CardapioModel> getCardapios(){
		return cardapios;
	}
	

	public void setCardapios(List<CardapioModel> cardapios) {
		this.cardapios = cardapios;
	}
	

	public CardapioModel getCardapioModel(){
		return cardapioModel;
	}
	

	public void setCardapioModel(CardapioModel cardapioModel) {
		this.cardapioModel = cardapioModel;
	}
	
	/***
	 * CARREGA OS PRATOS NA INICIALIZACAO 
	 */
	@PostConstruct

	public void init(){
		
		//Retorna os pratos cadastrados
		this.cardapios = cardapioRepository.getCardapio();
	}
	
	/***
	 * CARREGA INFORMACOES DE UM PRATO PARA SER EDITADO
	 * @param  cardapioModel
	 */
	
	public void editar(CardapioModel cardapioModel){
		
		this.cardapioModel = cardapioModel;
	}
	
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	
	public void alterarRegistro() throws ParseException {
		
		this.cardapioRepository.alterarRegistro(this.cardapioModel);
		
		//recarrega registros
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param cardapioModel
	 */
	
	public void excluirCardapio(CardapioModel cardapioModel){
		
		//exclui o prato do banco de dados
		this.cardapioRepository.excluir(cardapioModel.getId_prato());
		
		this.cardapios.remove(cardapioModel);
	}
	

	public void salvarNovoCardapio() throws ParseException{
		
		cardapioRepository.salvarNovoProduto(this.cardapioModel);
		
		this.cardapioModel = null;
		
		Uteis.mensagemInfo("Prato cadastrado com sucesso");
	}
}
