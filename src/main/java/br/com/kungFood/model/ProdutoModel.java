package br.com.kungFood.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
		String data = new ConvertDateToString().convertDateInsert(validade_produto);
		this.validade_produto = data;
	}
	
}
