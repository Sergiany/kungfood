package br.com.kungFood.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name ="tb_produto")

@NamedQueries({
		@NamedQuery(name = "ProdutoEntity.findAll", query= "SELECT p FROM ProdutoEntity p")
})
public class ProdutoEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "id_produto")
	private Integer id;
	
	@Column(name = "nm_produto")
	private String nome;
	
	@Column(name = "ds_produto")
	private String descricao;
	
	@Column(name = "vl_produto")
	private double valor;
	
	@Column(name = "qt_produto")
	private double quantidade;

	@Column(name = "validade_produto")
	private String validade;

	
	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getDescricao() {
		return descricao;
	}

	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public double getValor() {
		return valor;
	}

	
	public void setValor(double valor) {
		this.valor = valor;
	}

	
	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	
	public String getValidade() {
		return validade;
	}

	
	public void setValidade(String validade_produto) {
		this.validade = validade_produto;
	}

	
	
}
