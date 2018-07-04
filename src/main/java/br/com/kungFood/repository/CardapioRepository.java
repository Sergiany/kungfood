package br.com.kungFood.repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;


import br.com.kungFood.model.CardapioModel;
import br.com.kungFood.uteis.Uteis;
import br.com.kungFood.entity.CardapioEntity;

public class CardapioRepository {
	
	@Inject
	CardapioEntity cardapioEntity;
	
	EntityManager entityManager;
	
	
	public void salvarNovoProduto(CardapioModel cardapioModel) throws ParseException{
		
		entityManager = Uteis.getConexao();
		entityManager.getTransaction().begin();
		
		cardapioEntity = new CardapioEntity();
		//cardapioEntity.setId_prato(cardapioModel.getId_prato());
		cardapioEntity.setNm_prato(cardapioModel.getNm_prato());
		cardapioEntity.setDs_prato(cardapioModel.getDs_prato());
		cardapioEntity.setVl_prato(cardapioModel.getVl_prato());
		
		entityManager.persist(cardapioEntity);
		entityManager.flush();
		cardapioModel.setId_prato(cardapioEntity.getId_prato());
		entityManager.getTransaction().commit();
	}
	
	public CardapioEntity findCardapio(Integer id) {
		return entityManager.find(CardapioEntity.class, id);
	}
	
	
	public List<CardapioModel> getCardapio(){
		
		List<CardapioModel> cardapiosModel = new ArrayList<CardapioModel>();
		entityManager = Uteis.getConexao();
		
		Query query = entityManager.createNamedQuery("CardapioEntity.findAll");
		
		@SuppressWarnings("unchecked")
		Collection<CardapioEntity> cardapiosEntity = (Collection<CardapioEntity>)query.getResultList();
		
		CardapioModel cardapioModel = null;
		
		for (CardapioEntity cardapioEntity : cardapiosEntity){
			
			cardapioModel = new CardapioModel();
			cardapioModel.setId_prato(cardapioEntity.getId_prato());
			cardapioModel.setNm_prato(cardapioEntity.getNm_prato());
			cardapioModel.setDs_prato(cardapioEntity.getDs_prato());
			cardapioModel.setVl_prato(cardapioEntity.getVl_prato());
			
			cardapiosModel.add(cardapioModel);
			
		}
		return cardapiosModel;
	}
	
	/***
	 * CONSULTA UM PRATO CADASTRADA PELO CODIGO
	 * @param codigo
	 * @return
	 */

	
	private CardapioEntity getCardapio(int codigo){
		
		entityManager = Uteis.getConexao();
		
		return entityManager.find(CardapioEntity.class, codigo);
	}
	
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param cardapioModel
	 */
	
	public void alterarRegistro(CardapioModel cardapioModel) throws ParseException {
		
		try {
			 
			entityManager = Uteis.getConexao();
			entityManager.getTransaction().begin();
		
			CardapioEntity cardapioEntity = this.getCardapio(cardapioModel.getId_prato());
			
			cardapioEntity.setNm_prato(cardapioModel.getNm_prato());
			cardapioEntity.setDs_prato(cardapioModel.getDs_prato());
			cardapioEntity.setVl_prato(cardapioModel.getVl_prato());
			
			entityManager.merge(cardapioEntity);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if(msg == null || msg.length() == 0) {
				Integer id = cardapioModel.getId_prato();
				if (findCardapio(id) == null) {
					System.out.println("Cardapio n�o encontrada");
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
			CardapioEntity cardapio = new CardapioEntity();
			try {
				cardapio = entityManager.getReference(CardapioEntity.class, codigo);
				cardapio.getId_prato();
			} catch (EntityNotFoundException enfe) {
				
			}
			entityManager.remove(cardapio);
			entityManager.getTransaction().commit();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
}
