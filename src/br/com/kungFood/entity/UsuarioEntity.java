package br.com.kungFood.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 
@Table(name="tb_funcionario")
@Entity	
@NamedQuery(name = "UsuarioEntity.findUser", 
		    query= "SELECT u FROM UsuarioEntity u WHERE u.login = :usuario AND u.senha = :senha")
public class UsuarioEntity implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue
	@Column(name="id_funcionario")
	private String codigo;
 
	@Column(name="ds_login_funcionario")
	private String usuario;
 
	@Column(name="ds_senha_funcionario")
	private String senha;
 
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
 
