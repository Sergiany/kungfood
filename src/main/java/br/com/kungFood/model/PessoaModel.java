package br.com.kungFood.model;

import java.time.LocalDateTime;

import org.junit.Test;

public class PessoaModel {
 
	private Integer 	codigo;
	private String  	nome;
	private String  	sexo;
	private LocalDateTime	dataCadastro;
	private String  	email;
	private String  	endereco;
	private String  	origemCadastro;
	private UsuarioModel    usuarioModel;
 
	@Test
	public Integer getCodigo() {
		return codigo;
	}
	@Test
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	@Test
	public String getNome() {
		return nome;
	}
	@Test
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Test
	public String getSexo() {
		return sexo;
	}
	@Test
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	@Test
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	@Test
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@Test
	public String getEmail() {
		return email;
	}
	@Test
	public void setEmail(String email) {
		this.email = email;
	}
	@Test
	public String getEndereco() {
		return endereco;
	}
	@Test
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Test
	public String getOrigemCadastro() {
		return origemCadastro;
	}
	@Test
	public void setOrigemCadastro(String origemCadastro) {
		this.origemCadastro = origemCadastro;
	}
	@Test
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	@Test
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
 
}