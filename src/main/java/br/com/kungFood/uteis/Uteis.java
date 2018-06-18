package br.com.kungFood.uteis;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Named(value="Uteis") 
public class Uteis {
 	
	private static EntityManagerFactory EMF;
	private static EntityManager conexao;

	public static EntityManager getConexao() {
		conexao = JpaEntityManager().createEntityManager();
		return conexao;
	}

	public static synchronized EntityManagerFactory JpaEntityManager(){
		if (EMF == null){
			EMF = Persistence.createEntityManagerFactory("unit_app");
		}
		return EMF;
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