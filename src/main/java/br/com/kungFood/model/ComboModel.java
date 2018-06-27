package br.com.kungFood.model;

import java.io.Serializable;

public class ComboModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id_combo;
	private String nm_combo;
	private String ds_combo;
	private double vl_combo;
	public Integer getId_combo() {
		return id_combo;
	}
	public void setId_combo(Integer id_combo) {
		this.id_combo = id_combo;
	}
	public String getNm_combo() {
		return nm_combo;
	}
	public void setNm_combo(String nm_combo) {
		this.nm_combo = nm_combo;
	}
	public String getDs_combo() {
		return ds_combo;
	}
	public void setDs_combo(String ds_combo) {
		this.ds_combo = ds_combo;
	}
	public double getVl_combo() {
		return vl_combo;
	}
	public void setVl_combo(double vl_combo) {
		this.vl_combo = vl_combo;
	}
	
}
