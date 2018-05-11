package br.com.kungFood.model;

import java.io.Serializable;

import org.junit.Test;

import br.com.kungFood.uteis.ConvertDateToString;

public class ProdutoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id_produto;
	private String nm_produto;
	private String ds_produto;
	private double vl_produto;
	private double qt_produto;
	private String validade_produto;
	
	public ProdutoModel() {
		
	}

	@Test
	public Integer getId_produto() {
		return id_produto;
	}

	@Test
	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	@Test
	public String getNm_produto() {
		return nm_produto;
	}

	@Test
	public void setNm_produto(String nm_produto) {
		this.nm_produto = nm_produto;
	}
	
	@Test
	public String getDs_produto() {
		return ds_produto;
	}

	@Test
	public void setDs_produto(String ds_produto) {
		this.ds_produto = ds_produto;
	}

	@Test
	public double getVl_produto() {
		return vl_produto;
	}

	@Test
	public void setVl_produto(double vl_produto) {
		this.vl_produto = vl_produto;
	}

	@Test
	public double getQt_produto() {
		return qt_produto;
	}

	@Test
	public void setQt_produto(double qt_produto) {
		this.qt_produto = qt_produto;
	}

	@Test
	public String getValidade_produto() {
		return validade_produto;
	}

	@Test
	public void setValidade_produto(String validade_produto) {
		String data = new ConvertDateToString().convertDateInsert(validade_produto);
		this.validade_produto = data;
	}
	
}
