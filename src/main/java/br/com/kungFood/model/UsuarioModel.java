package br.com.kungFood.model;

import java.io.Serializable;

import org.junit.Test;

public class UsuarioModel implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
 
	private String codigo;
	private String usuario;
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