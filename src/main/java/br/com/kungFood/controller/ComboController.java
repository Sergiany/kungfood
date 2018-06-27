package br.com.kungFood.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.kungFood.model.ComboModel;
import br.com.kungFood.repository.ComboRepository;
import br.com.kungFood.uteis.Uteis;


@Named(value = "ComboController")
@ViewScoped
public class ComboController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject transient
	private ComboModel comboModel;
	
	@Produces
	private List<ComboModel> combos;
	
	@Inject transient
	private ComboRepository comboRepository;

	public ComboModel getComboModel() {
		return comboModel;
	}

	public void setComboModel(ComboModel comboModel) {
		this.comboModel = comboModel;
	}

	public List<ComboModel> getCombos() {
		return combos;
	}

	public void setCombos(List<ComboModel> combos) {
		this.combos = combos;
	}

	public ComboRepository getComboRepository() {
		return comboRepository;
	}

	public void setComboRepository(ComboRepository comboRepository) {
		this.comboRepository = comboRepository;
	}
	
	/***
	 * CARREGA OS COMBOS NA INICIALIZACAO 
	 */
	@PostConstruct

	public void init(){
		
		//Retorna os combos cadastrados
		this.combos= comboRepository.getCombo();
	}
	
	/***
	 * CARREGA INFORMACOES DE UM COMBO PARA SER EDITADO
	 * @param  comboModel
	 */
	
	public void editar(ComboModel comboModel){
		
		this.comboModel = comboModel;
	}
	
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	
	public void alterarRegistro() throws ParseException {
		
		this.comboRepository.alterarRegistro(this.comboModel);
		
		//recarrega registros
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param comboModel
	 */
	
	public void excluirCombo(ComboModel comboModel){
		
		//exclui o combo do banco de dados
		this.comboRepository.excluir(comboModel.getId_combo());
		
		this.combos.remove(comboModel);
	}
	

	public void salvarNovoCombo(){
		
		comboRepository.salvarNovoCombo(this.comboModel);
		
		this.comboModel = null;
		
		Uteis.mensagemInfo("Combo cadastrado com sucesso");
	}
}
