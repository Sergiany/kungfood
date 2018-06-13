package br.com.kungFood.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.kungFood.model.UsuarioModel;
import br.com.kungFood.uteis.Uteis;
import br.com.kungFood.entity.UsuarioEntity;
 
 
public class UsuarioRepository implements Serializable {
 
 
	private static final long serialVersionUID = 1L;
	
	UsuarioEntity usuarioEntity;
	EntityManager entityManager;
 
	
	public UsuarioEntity validaUsuario(UsuarioModel usuarioModel){
 
		try {
 
			//QUERY QUE VAI SER EXECUTADA (UsuarioEntity.findUser) 	
			Query query = Uteis.jpaEntityManager().createNamedQuery("UsuarioEntity.findUser");
 
			//PARÂMETROS DA QUERY
			query.setParameter("usuario", usuarioModel.getUsuario());
			query.setParameter("senha", usuarioModel.getSenha());
 
			//RETORNA O USUARIO SE FOR LOCALIZADO
			return (UsuarioEntity)query.getSingleResult();
 
		} catch (Exception e) {
 
			return null;
		}
	}
	
	public void salvarNovoRegistro(UsuarioModel usuarioModel){
		 
		entityManager =  Uteis.jpaEntityManager();
 
		usuarioEntity = new UsuarioEntity();
		usuarioEntity.setUsuario(usuarioModel.getUsuario());
		usuarioEntity.setSenha(usuarioModel.getSenha());
 
		entityManager.persist(usuarioEntity);
 
	}
	public List<UsuarioModel> getUsuarios(){
		List<UsuarioModel> usuariosModel = new ArrayList<UsuarioModel>();
		 
		entityManager =  Uteis.jpaEntityManager();
 
		Query query = entityManager.createNamedQuery("UsuarioEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<UsuarioEntity> usuariosEntity = (Collection<UsuarioEntity>)query.getResultList();
 
		UsuarioModel usuarioModel = null;
 
		for (UsuarioEntity usuarioEntity : usuariosEntity) {
 
			usuarioModel = new UsuarioModel();
			usuarioModel.setCodigo(usuarioEntity.getCodigo());
			usuarioModel.setUsuario(usuarioEntity.getUsuario());
			usuarioModel.setSenha(usuarioEntity.getSenha());

			 
			usuariosModel.add(usuarioModel);
		}
 
		return usuariosModel;
	}
}
