package br.com.kungFood.repository;

import java.io.Serializable;

import javax.persistence.Query;

import org.junit.Test;

import br.com.kungFood.model.UsuarioModel;
import br.com.kungFood.uteis.Uteis;
import br.com.kungFood.entity.UsuarioEntity;
 
 
public class UsuarioRepository implements Serializable {
 
 
	private static final long serialVersionUID = 1L;
 
	@Test
	public UsuarioEntity validaUsuario(UsuarioModel usuarioModel){
 
		try {
 
			//QUERY QUE VAI SER EXECUTADA (UsuarioEntity.findUser) 	
			Query query = Uteis.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");
 
			//PARÂMETROS DA QUERY
			query.setParameter("usuario", usuarioModel.getUsuario());
			query.setParameter("senha", usuarioModel.getSenha());
 
			//RETORNA O USUARIO SE FOR LOCALIZADO
			return (UsuarioEntity)query.getSingleResult();
 
		} catch (Exception e) {
 
			return null;
		}
 
 
 
	}
}
