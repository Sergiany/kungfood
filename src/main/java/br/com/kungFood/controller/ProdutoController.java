package br.com.kungFood.controller;

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
import br.com.kungFood.uteis.Uteis;

@Named(value="ProdutoController")
@ViewScoped
public class ProdutoController implements Serializable{

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
		this.produtos = produtoRepository.getProduto();
	}
	
	/***
	 * CARREGA INFORMACOES DE UM PRODUTO PARA SER EDITADO
	 * @param  produtoModel
	 */
	@Test
	public void editar(ProdutoModel produtoModel){
		
		this.produtoModel = produtoModel;
	}
	
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	@Test
	public void alterarRegistro(){
		
		this.produtoRepository.alterarRegistro(this.produtoModel);
		
		//recarrega registros
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param produtoModel
	 */
	@Test
	public void excluirProduto(ProdutoModel produtoModel){
		
		//exclui o produto do banco de dados
		this.produtoRepository.excluirRegistro(produtoModel.getId_produto());
		
		this.produtos.remove(produtoModel);
	}
	
	/**
	 * SALVA UM NOVO REGISTRO VIA INPUT
	 */
	@Test
	public void salvarNovoProduto() {

		produtoRepository.salvarNovoProduto(this.produtoModel);

		this.produtoModel = null;

		Uteis.MensagemInfo("Produto cadastrado com sucesso");

	}
}
