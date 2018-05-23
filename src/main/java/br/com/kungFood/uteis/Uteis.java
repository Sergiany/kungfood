package br.com.kungFood.uteis;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

@Named(value="Uteis") 
public class Uteis {
 	
	public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("unit_app");
	
	public static EntityManager jpaEntityManager(){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		ExternalContext externalContext = facesContext.getExternalContext();
 
		HttpServletRequest request  = (HttpServletRequest)externalContext.getRequest();
 
		return (EntityManager)request.getAttribute("entityManager");
	}
 
	//MOSTRAR MENSAGEM
	
	public static void mensagem(String mensagem){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		facesContext.addMessage(null, new FacesMessage("Alerta",mensagem));
	}
 
	//MOSTRAR MENSAGEM
	
	public static void mensagemAtencao(String mensagem){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", mensagem));
	}
 
	//MOSTRAR MENSAGEM
	
	public static void mensagemInfo(String mensagem){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
	}
}