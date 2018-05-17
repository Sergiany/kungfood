package br.com.kungFood.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import br.com.kungFood.model.CardapioModel;
import br.com.kungFood.uteis.Uteis;
import br.com.kungFood.entity.CardapioEntity;

public class CardapioRepository {
	
	@Inject
	CardapioEntity cardapioEntity;
	
	EntityManager entityManager;
	
	@Test
	public void salvarNovoProduto(CardapioModel cardapioModel){
		
		entityManager = Uteis.JpaEntityManager();
		
		cardapioEntity = new CardapioEntity();
		cardapioEntity.setId_prato(cardapioModel.getId_prato());
		cardapioEntity.setNm_prato(cardapioModel.getNm_prato());
		cardapioEntity.setDs_prato(cardapioModel.getDs_prato());
		cardapioEntity.setVl_prato(cardapioModel.getVl_prato());
		
		entityManager.persist(cardapioEntity);
	}
	
	@Test
	public List<CardapioModel> getCardapio(){
		
		List<CardapioModel> cardapiosModel = new ArrayList<CardapioModel>();
		
		entityManager = Uteis.JpaEntityManager();
		
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

	@Test
	private CardapioEntity getCardapio(int codigo){
		
		entityManager = Uteis.JpaEntityManager();
		
		return entityManager.find(CardapioEntity.class, codigo);
	}
	
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param cardapioModel
	 */
	@Test
	public void alterarRegistro(CardapioModel cardapioModel){
		entityManager = Uteis.JpaEntityManager();
		
		CardapioEntity cardapioEntity = this.getCardapio(cardapioModel.getId_prato());
		
		cardapioEntity.setNm_prato(cardapioModel.getNm_prato());
		cardapioEntity.setDs_prato(cardapioModel.getDs_prato());
		cardapioEntity.setVl_prato(cardapioModel.getVl_prato());
		
		entityManager.merge(cardapioEntity);
		
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	@Test
	public void excluirRegistro(int codigo){
		entityManager = Uteis.JpaEntityManager();
		
		CardapioEntity cardapioEntity = this.getCardapio(codigo);
		
		entityManager.remove(cardapioEntity);
	}
}
