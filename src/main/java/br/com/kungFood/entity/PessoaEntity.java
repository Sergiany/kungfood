package br.com.kungFood.entity;

import java.time.LocalDateTime;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.junit.Test;
 
 
@Entity
@Table(name="tb_cliente")
 
@NamedQueries({
 
	@NamedQuery(name = "PessoaEntity.findAll",query= "SELECT p FROM PessoaEntity p")
 
})
public class PessoaEntity {
 
	@Id
	@GeneratedValue
	@Column(name = "id_cliente")
	private Integer 		codigo;
 
	@Column(name = "nm_cliente")
	private String  		nome;
 
	@Column(name = "fl_sexo_cliente")
	private String  		sexo;
 
	@Column(name = "dt_cadastro_cliente")
	private LocalDateTime	dataCadastro;
 
	@Column(name = "ds_email_cliente")
	private String  		email;
 
	@Column(name = "ds_endereco_cliente")
	private String  		endereco;
 
	@Column(name = "fl_origemCadastro_cliente")
	private String  		origemCadastro;
 
	@OneToOne
	@JoinColumn(name="id_admin_cadastro")
	private UsuarioEntity	usuarioEntity;
 
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
	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}
	@Test
	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
 
}