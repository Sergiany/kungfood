package br.com.kungFood.repository.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.junit.Test;


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

	@Test
	public Integer getId() {
		return id;
	}

	@Test
	public void setId(Integer id) {
		this.id = id;
	}

	@Test
	public String getNome() {
		return nome;
	}

	@Test
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Test
	public String getDescricao() {
		return descricao;
	}

	@Test
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Test
	public double getValor() {
		return valor;
	}

	@Test
	public void setValor(double valor) {
		this.valor = valor;
	}

	@Test
	public double getQuantidade() {
		return quantidade;
	}

	@Test
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	@Test
	public String getValidade() {
		return validade;
	}

	@Test
	public void setValidade(String validade_produto) {
		this.validade = validade_produto;
	}

	
	
}
