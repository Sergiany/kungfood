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
