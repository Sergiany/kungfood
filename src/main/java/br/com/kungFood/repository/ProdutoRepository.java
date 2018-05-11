package br.com.kungFood.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import br.com.kungFood.model.ProdutoModel;
import br.com.kungFood.repository.entity.ProdutoEntity;
import br.com.kungFood.uteis.Uteis;

public class ProdutoRepository {
	
	@Inject
	ProdutoEntity produtoEntity;
	
	EntityManager entityManager;
	
	@Test
	public void SalvarNovoProduto(ProdutoModel produtoModel){
		
		entityManager = Uteis.JpaEntityManager();
		
		produtoEntity = new ProdutoEntity();
		produtoEntity.setId(produtoModel.getId_produto());
		produtoEntity.setNome(produtoModel.getNm_produto());
		produtoEntity.setDescricao(produtoModel.getDs_produto());
		produtoEntity.setValor(produtoModel.getVl_produto());
		produtoEntity.setQuantidade(produtoModel.getQt_produto());
		produtoEntity.setValidade(produtoModel.getValidade_produto());
		
		entityManager.persist(produtoEntity);
	}
	
	@Test
	public List<ProdutoModel> GetProduto(){
		
		List<ProdutoModel> produtosModel = new ArrayList<ProdutoModel>();
		
		entityManager = Uteis.JpaEntityManager();
		
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

	@Test
	private ProdutoEntity GetProduto(int codigo){
		
		entityManager = Uteis.JpaEntityManager();
		
		return entityManager.find(ProdutoEntity.class, codigo);
	}
	
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param produtoModel
	 */
	@Test
	public void AlterarRegistro(ProdutoModel produtoModel){
		entityManager = Uteis.JpaEntityManager();
		
		ProdutoEntity produtoEntity = this.GetProduto(produtoModel.getId_produto());
		
		produtoEntity.setNome(produtoModel.getNm_produto());
		produtoEntity.setDescricao(produtoModel.getDs_produto());
		produtoEntity.setValor(produtoModel.getVl_produto());
		produtoEntity.setQuantidade(produtoModel.getQt_produto());
		produtoEntity.setValidade(produtoModel.getValidade_produto());
		
		
		
		entityManager.merge(produtoEntity);
		
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	@Test
	public void ExcluirRegistro(int codigo){
		entityManager = Uteis.JpaEntityManager();
		
		ProdutoEntity produtoEntity = this.GetProduto(codigo);
		
		entityManager.remove(produtoEntity);
	}
}