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
 
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
		public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getOrigemCadastro() {
		return origemCadastro;
	}
	
	public void setOrigemCadastro(String origemCadastro) {
		this.origemCadastro = origemCadastro;
	}
	
	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}
	
	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
 
}