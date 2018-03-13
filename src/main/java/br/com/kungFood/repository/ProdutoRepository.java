package br.com.kungFood.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import br.com.kungFood.model.ProdutoModel;
import br.com.kungFood.repository.entity.ProdutoEntity;
import br.com.kungFood.uteis.Uteis;

public class ProdutoRepository {
	
	@Inject
	ProdutoEntity produtoEntity;
	
	EntityManager entityManager;
	
	public void SalvarNovoProduto(ProdutoModel produtoModel){
		
		entityManager = Uteis.JpaEntityManager();
		
		produtoEntity = new ProdutoEntity();
		produtoEntity.setId_produto(produtoModel.getId());
		produtoEntity.setNm_produto(produtoModel.getNome());
		produtoEntity.setDs_produto(produtoModel.getDescrição());
		produtoEntity.setVl_produto(produtoModel.getValor());
		produtoEntity.setQt_produto(produtoModel.getQuantidade());
		produtoEntity.setValidade_produto(produtoModel.getValidade());
		
		entityManager.persist(produtoEntity);
	}
	
	public List<ProdutoModel> GetProduto(){
		
		List<ProdutoModel> produtosModel = new ArrayList<ProdutoModel>();
		
		entityManager = Uteis.JpaEntityManager();
		
		Query query = entityManager.createNamedQuery("ProdutoEntity.findAll");
		
		@SuppressWarnings("unchecked")
		Collection<ProdutoEntity> produtosEntity = (Collection<ProdutoEntity>)query.getResultList();
		
		ProdutoModel produtoModel = null;
		
		for (ProdutoEntity produtoEntity : produtosEntity){
			
			produtoModel = new ProdutoModel();
			produtoModel.setId(produtoEntity.getId_produto());
			produtoModel.setNome(produtoEntity.getNm_produto());
			produtoModel.setDescrição(produtoEntity.getDs_produto());
			produtoModel.setValor(produtoEntity.getVl_produto());
			produtoModel.setQuantidade(produtoEntity.getQt_produto());
			produtoModel.setValidade(produtoEntity.getValidade_produto());
			
			produtosModel.add(produtoModel);
			
		}
		return produtosModel;
	}
	
	/***
	 * CONSULTA UM PRATO CADASTRADA PELO CODIGO
	 * @param codigo
	 * @return
	 */

	private ProdutoEntity GetProduto(int codigo){
		
		entityManager = Uteis.JpaEntityManager();
		
		return entityManager.find(ProdutoEntity.class, codigo);
	}
	
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param produtoModel
	 */
	public void AlterarRegistro(ProdutoModel produtoModel){
		entityManager = Uteis.JpaEntityManager();
		
		ProdutoEntity produtoEntity = this.GetProduto(produtoModel.getId());
		
		produtoEntity.setNm_produto(produtoModel.getNome());
		produtoEntity.setDs_produto(produtoModel.getDescrição());
		produtoEntity.setVl_produto(produtoModel.getValor());
		
		entityManager.merge(produtoEntity);
		
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	public void ExcluirRegistro(int codigo){
		entityManager = Uteis.JpaEntityManager();
		
		ProdutoEntity produtoEntity = this.GetProduto(codigo);
		
		entityManager.remove(produtoEntity);
	}
}