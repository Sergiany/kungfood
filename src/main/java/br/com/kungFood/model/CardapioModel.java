package br.com.kungFood.model;

import java.io.Serializable;

import org.junit.Test;

public class CardapioModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id_prato;
	private String nm_prato;
	private String ds_prato;
	private double vl_prato;
	
	@Test
	public Integer getId_prato() {
		return id_prato;
	}
	@Test
	public void setId_prato(Integer id_prato) {
		this.id_prato = id_prato;
	}
	@Test
	public String getNm_prato() {
		return nm_prato;
	}
	@Test
	public void setNm_prato(String nm_prato) {
		this.nm_prato = nm_prato;
	}
	@Test
	public String getDs_prato() {
		return ds_prato;
	}
	@Test
	public void setDs_prato(String ds_prato) {
		this.ds_prato = ds_prato;
	}
	@Test
	public double getVl_prato() {
		return vl_prato;
	}
	@Test
	public void setVl_prato(double vl_prato) {
		this.vl_prato = vl_prato;
	}
	
}
