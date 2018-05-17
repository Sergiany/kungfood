package br.com.kungFood.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.junit.Test;
 
@Table(name="tb_admin")
@Entity	
@NamedQuery(name = "UsuarioEntity.findUser", 
		    query= "SELECT u FROM UsuarioEntity u WHERE u.usuario = :usuario AND u.senha = :senha")
public class UsuarioEntity implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue
	@Column(name="id_admin")
	private String codigo;
 
	@Column(name="ds_login_admin")
	private String usuario;
 
	@Column(name="ds_senha_admin")
	private String senha;
 
	@Test
	public String getCodigo() {
		return codigo;
	}
	@Test
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Test
	public String getUsuario() {
		return usuario;
	}
	@Test
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Test
	public String getSenha() {
		return senha;
	}
	@Test
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
 
