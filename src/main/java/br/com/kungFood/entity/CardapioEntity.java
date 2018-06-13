package br.com.kungFood.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name ="tb_cardapio")

@NamedQueries({
		@NamedQuery(name = "CardapioEntity.findAll", query= "SELECT p FROM CardapioEntity p")
})
public class CardapioEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "id_prato")
	private Integer id_prato;
	
	@Column(name = "nm_prato")
	private String nm_prato;
	
	@Column(name = "ds_prato")
	private String ds_prato;
	
	@Column(name = "vl_prato")
	private double vl_prato;

	
	public Integer getId_prato() {
		return id_prato;
	}

	
	public void setId_prato(Integer id_prato) {
		this.id_prato = id_prato;
	}

	
	public String getNm_prato() {
		return nm_prato;
	}

	
	public void setNm_prato(String nm_prato) {
		this.nm_prato = nm_prato;
	}

	
	public String getDs_prato() {
		return ds_prato;
	}

	
	public void setDs_prato(String ds_prato) {
		this.ds_prato = ds_prato;
	}

	
	public double getVl_prato() {
		return vl_prato;
	}


	public void setVl_prato(double vl_prato) {
		this.vl_prato = vl_prato;
	}
	
}
