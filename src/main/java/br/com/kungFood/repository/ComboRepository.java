package br.com.kungFood.repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import br.com.kungFood.entity.ComboEntity;
import br.com.kungFood.model.ComboModel;
import br.com.kungFood.uteis.Uteis;

public class ComboRepository {

	@Inject
	ComboEntity comboEntity;

	EntityManager entityManager;

	public void salvarNovoCombo(ComboModel comboModel) {

		entityManager = Uteis.getConexao();
		entityManager.getTransaction().begin();

		comboEntity = new ComboEntity();
		comboEntity.setId_combo(comboModel.getId_combo());
		comboEntity.setNm_combo(comboModel.getNm_combo());
		comboEntity.setDs_combo(comboModel.getDs_combo());
		comboEntity.setVl_combo(comboModel.getVl_combo());

		entityManager.persist(comboEntity);
		entityManager.flush();
		comboModel.setId_combo(comboEntity.getId_combo());
		entityManager.getTransaction().commit();
	}
	public ComboEntity findCombo(Integer id) {
		return entityManager.find(ComboEntity.class, id);
	}
	
	
	public List<ComboModel> getCombo(){
		
		List<ComboModel> combosModel = new ArrayList<ComboModel>();
		entityManager = Uteis.getConexao();
		
		Query query = entityManager.createNamedQuery("ComboEntity.findAll");
		
		@SuppressWarnings("unchecked")
		Collection<ComboEntity> combosEntity = (Collection<ComboEntity>)query.getResultList();
		
		ComboModel comboModel = null;
		
		for (ComboEntity comboEntity : combosEntity){
			
			comboModel = new ComboModel();
			comboModel.setId_combo(comboEntity.getId_combo());
			comboModel.setNm_combo(comboEntity.getNm_combo());
			comboModel.setDs_combo(comboEntity.getDs_combo());
			comboModel.setVl_combo(comboEntity.getVl_combo());
			
			combosModel.add(comboModel);
			
		}
		return combosModel;
	}
	
	/***
	 * CONSULTA UM COMBO CADASTRADO PELO CODIGO
	 * @param codigo
	 * @return
	 */

	
	private ComboEntity getCombo(int codigo){
		
		entityManager = Uteis.getConexao();
		
		return entityManager.find(ComboEntity.class, codigo);
	}
	
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param comboModel
	 */
	
	public void alterarRegistro(ComboModel comboModel) throws ParseException {
		
		try {
		
			ComboEntity comboEntity = this.getCombo(comboModel.getId_combo());
			
			comboEntity.setNm_combo(comboModel.getNm_combo());
			comboEntity.setDs_combo(comboModel.getDs_combo());
			comboEntity.setVl_combo(comboModel.getVl_combo());
			
			entityManager = Uteis.getConexao();
			entityManager.getTransaction().begin();
			entityManager.merge(comboEntity);
			entityManager.flush();
			comboModel.setId_combo(comboEntity.getId_combo());
			entityManager.getTransaction().commit();
			
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if(msg == null || msg.length() == 0) {
				Integer id = comboModel.getId_combo();
				if (findCombo(id) == null) {
					System.out.println("Combo não encontrado");
				}
			}
			throw ex;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	
	public void excluir(int codigo) {
		try {
			entityManager = Uteis.getConexao();
			entityManager.getTransaction().begin();
			ComboEntity combo = new ComboEntity();
			try {
				combo = entityManager.getReference(ComboEntity.class, codigo);
				combo.getId_combo();
			} catch (EntityNotFoundException enfe) {
				
			}
			entityManager.remove(combo);
			entityManager.getTransaction().commit();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}


}
