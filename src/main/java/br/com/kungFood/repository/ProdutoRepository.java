package br.com.kungFood.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.kungFood.entity.ProdutoEntity;
import br.com.kungFood.model.ProdutoModel;
import br.com.kungFood.uteis.Uteis;

public class ProdutoRepository {
	
	@Inject
	ProdutoEntity produtoEntity;
	
	EntityManager entityManager;
	
	
//	public void salvarNovoProduto(ProdutoModel produtoModel){
//		
//		entityManager = Uteis.jpaEntityManager();
//		
//		produtoEntity = new ProdutoEntity();
//		//O bd cria o Id automaticamente
//		//produtoEntity.setId(produtoModel.getId_produto());
//		produtoEntity.setNome(produtoModel.getNm_produto());
//		produtoEntity.setDescricao(produtoModel.getDs_produto());
//		produtoEntity.setValor(produtoModel.getVl_produto());
//		produtoEntity.setQuantidade(produtoModel.getQt_produto());
//		produtoEntity.setValidade(produtoModel.getValidade_produto());
//		
//		entityManager.persist(produtoEntity);
//	}
//	
	public void salvar(ProdutoModel produtoModel){
		
		entityManager = Uteis.EMF.createEntityManager();
		entityManager.getTransaction().begin();
		
		produtoEntity = new ProdutoEntity();
		//O bd cria o Id automaticamente
		//produtoEntity.setId(produtoModel.getId_produto());
		produtoEntity.setNome(produtoModel.getNm_produto());
		produtoEntity.setDescricao(produtoModel.getDs_produto());
		produtoEntity.setValor(produtoModel.getVl_produto());
		produtoEntity.setQuantidade(produtoModel.getQt_produto());
		produtoEntity.setValidade(produtoModel.getValidade_produto());
		
		entityManager.persist(produtoEntity);
		entityManager.flush();
		produtoModel.setId_produto(produtoEntity.getId());
		entityManager.getTransaction().commit();
	}
	
	public List<ProdutoModel> findAll(){
		
		List<ProdutoModel> produtosModel = new ArrayList<ProdutoModel>();
		
		entityManager = Uteis.EMF.createEntityManager();
		
		Query query = entityManager.createNamedQuery("ProdutoEntity.findAll");
		
		@SuppressWarnings("unchecked")
		Collection<ProdutoEntity> produtosEntity = (Collection<ProdutoEntity>)query.getResultList();
		
		ProdutoModel produtoModel = null;
		
		for (ProdutoEntity produtoEntity : produtosEntity){
			
			produtoModel = new ProdutoModel();
			produtoModel.setId_produto(produtoEntity.getId());
			produtoModel.setNm_produto(produtoEntity.getNome());
			produtoModel.setDs_produto(produtoEntity.getDescricao());
			produtoModel.setVl_produto(produtoEntity.getValor());
			produtoModel.setQt_produto(produtoEntity.getQuantidade());
			produtoModel.setValidade_produto(produtoEntity.getValidade());
			
			produtosModel.add(produtoModel);
			
		}
		return produtosModel;
	}
	
	public void excluir(int codigo){
		entityManager = Uteis.EMF.createEntityManager();
		// entityManager = Uteis.jpaEntityManager();
		
		ProdutoEntity produtoEntity = entityManager.find(ProdutoEntity.class, codigo);
		entityManager.getTransaction().begin();
		entityManager.remove(produtoEntity);
		entityManager.getTransaction().commit();
	}
	
	
	public List<ProdutoModel> getProdutos(){
		
		List<ProdutoModel> produtosModel = new ArrayList<ProdutoModel>();
		
		entityManager = Uteis.EMF.createEntityManager();
		// entityManager = Uteis.jpaEntityManager();
		
		Query query = entityManager.createNamedQuery("ProdutoEntity.findAll");
		
		@SuppressWarnings("unchecked")
		Collection<ProdutoEntity> produtosEntity = (Collection<ProdutoEntity>)query.getResultList();
		
		ProdutoModel produtoModel = null;
		
		for (ProdutoEntity produtoEntity : produtosEntity){
			
			produtoModel = new ProdutoModel();
			produtoModel.setId_produto(produtoEntity.getId());
			produtoModel.setNm_produto(produtoEntity.getNome());
			produtoModel.setDs_produto(produtoEntity.getDescricao());
			produtoModel.setVl_produto(produtoEntity.getValor());
			produtoModel.setQt_produto(produtoEntity.getQuantidade());
			produtoModel.setValidade_produto(produtoEntity.getValidade());
			
			produtosModel.add(produtoModel);
			
		}
		return produtosModel;
	}
	
	/***
	 * CONSULTA UM PRODUTO CADASTRADA PELO CODIGO
	 * @param codigo
	 * @return
	 */

	
	private ProdutoEntity getProduto(int codigo){
		
		entityManager = Uteis.EMF.createEntityManager();
		// entityManager = Uteis.jpaEntityManager();
		
		return entityManager.find(ProdutoEntity.class, codigo);
	}
	
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param produtoModel
	 */
	
	public void alterar(ProdutoModel produtoModel){
		//entityManager = Uteis.jpaEntityManager();
		entityManager = Uteis.EMF.createEntityManager();
		entityManager.getTransaction().begin();
		
		ProdutoEntity produtoEntity = this.getProduto(produtoModel.getId_produto());
		
		produtoEntity.setNome(produtoModel.getNm_produto());
		produtoEntity.setDescricao(produtoModel.getDs_produto());
		produtoEntity.setValor(produtoModel.getVl_produto());
		produtoEntity.setQuantidade(produtoModel.getQt_produto());
		produtoEntity.setValidade(produtoModel.getValidade_produto());
		
		entityManager.merge(produtoEntity);
		// entityManager.persist(produtoEntity);
		entityManager.flush();
		produtoModel.setId_produto(produtoEntity.getId());
		entityManager.getTransaction().commit();
		
		
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	
//	public void excluirRegistro(int codigo){
//		entityManager = Uteis.jpaEntityManager();
//		
//		ProdutoEntity produtoEntity = this.getProduto(codigo);
//		
//		entityManager.remove(produtoEntity);
//	}
}