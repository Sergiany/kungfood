package br.com.kungFood.repository.entity;

import java.util.Date;

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
	private Integer id_produto;
	
	@Column(name = "nm_produto")
	private String nm_produto;
	
	@Column(name = "ds_produto")
	private String ds_produto;
	
	@Column(name = "vl_produto")
	private double vl_produto;
	
	@Column(name = "qt_produto")
	private double qt_produto;

	@Column(name = "validade_produto")
	private String validade_produto;

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public String getNm_produto() {
		return nm_produto;
	}

	public void setNm_produto(String nm_produto) {
		this.nm_produto = nm_produto;
	}

	public String getDs_produto() {
		return ds_produto;
	}

	public void setDs_produto(String ds_produto) {
		this.ds_produto = ds_produto;
	}

	public double getVl_produto() {
		return vl_produto;
	}

	public void setVl_produto(double vl_produto) {
		this.vl_produto = vl_produto;
	}

	public double getQt_produto() {
		return qt_produto;
	}

	public void setQt_produto(double qt_produto) {
		this.qt_produto = qt_produto;
	}

	public String getValidade_produto() {
		return validade_produto;
	}

	public void setValidade_produto(String validade_produto) {
		this.validade_produto = validade_produto;
	}
	
}
