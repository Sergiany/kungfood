package br.com.kungFood.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.kungFood.model.ComboModel;
import br.com.kungFood.repository.ComboRepository;


@Named(value="consultarComboCarouselController")
@ViewScoped
public class ConsultarComboCarouselController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject transient
	private ComboRepository comboRepository;
	
	@Produces
	private List<ComboModel> combos;
	
	
	
	public List<ComboModel> getCombos(){
		return combos;
	}
	
	@PostConstruct

	private void init(){
		
		this.combos = comboRepository.getCombo();
	}
}
