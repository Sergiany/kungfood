package br.com.kungFood.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import br.com.kungFood.model.CardapioModel;
import br.com.kungFood.repository.CardapioRepository;


@Named(value="consultarCardapioCarouselController")
@ViewScoped
public class ConsultarCardapioCarouselController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject transient
	private CardapioRepository cardapioRepository;
	
	@Produces
	private List<CardapioModel> cardapios;
	
	
	
	public List<CardapioModel> getCardapios(){
		return cardapios;
	}
	
	@PostConstruct

	private void init(){
		
		this.cardapios = cardapioRepository.getCardapio();
	}
	
}
