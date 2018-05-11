package br.com.kungFood.pessoa.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;

import br.com.kungFood.model.ProdutoModel;
import br.com.kungFood.repository.ProdutoRepository;

@Named(value="consultarProdutoController")
@ViewScoped
public class ConsultarProdutoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject transient
	private ProdutoModel produtoModel;
	
	@Produces
	private List<ProdutoModel> produtos;
	
	@Inject transient
	private ProdutoRepository produtoRepository;
	
	@Test
	public List<ProdutoModel> getProdutos(){
		return produtos;
	}
	
	@Test
	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}
	
	@Test
	public ProdutoModel getProdutoModel(){
		return produtoModel;
	}
	
	@Test
	public void setProdutoModel(ProdutoModel produtoModel) {
		this.produtoModel = produtoModel;
	}
	
	
	/***
	 * CARREGA OS PRODUTOS NA INICIALIZACAO 
	 */
	@PostConstruct
	@Test
	public void init(){
		
		//Retorna os produtos cadastrados
		this.produtos = produtoRepository.GetProduto();
	}
	
	/***
	 * CARREGA INFORMACOES DE UM PRODUTO PARA SER EDITADO
	 * @param  produtoModel
	 */
	@Test
	public void Editar(ProdutoModel produtoModel){
		
		this.produtoModel = produtoModel;
	}
	
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	@Test
	public void AlterarRegistro(){
		
		this.produtoRepository.AlterarRegistro(this.produtoModel);
		
		//recarrega registros
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param produtoModel
	 */
	@Test
	public void ExcluirProduto(ProdutoModel produtoModel){
		
		//exclui o produto do banco de dados
		this.produtoRepository.ExcluirRegistro(produtoModel.getId_produto());
		
		this.produtos.remove(produtoModel);
	}
}
