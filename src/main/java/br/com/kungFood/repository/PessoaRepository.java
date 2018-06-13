package br.com.kungFood.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;



import br.com.kungFood.model.PessoaModel;
import br.com.kungFood.model.UsuarioModel;
import br.com.kungFood.uteis.Uteis;
import br.com.kungFood.entity.PessoaEntity;
import br.com.kungFood.entity.UsuarioEntity;
 
public class PessoaRepository {
 
	@Inject
	PessoaEntity pessoaEntity;
 
	EntityManager entityManager;
 
	/***
	 * METODO RESPONSAVEL POR SALVAR UMA NOVA PESSOA
	 * @param pessoaModel
	 */
	public void salvar(PessoaModel pessoaModel){
 
		entityManager = Uteis.EMF.createEntityManager();
		entityManager.getTransaction().begin();
		//entityManager =  Uteis.jpaEntityManager();
 
		pessoaEntity = new PessoaEntity();
		pessoaEntity.setDataCadastro(LocalDateTime.now());
		pessoaEntity.setEmail(pessoaModel.getEmail());
		pessoaEntity.setEndereco(pessoaModel.getEndereco());
		pessoaEntity.setNome(pessoaModel.getNome());
		pessoaEntity.setOrigemCadastro(pessoaModel.getOrigemCadastro());
		pessoaEntity.setSexo(pessoaModel.getSexo());
 
		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, pessoaModel.getUsuarioModel().getCodigo()); 
 
		pessoaEntity.setUsuarioEntity(usuarioEntity);
 
		entityManager.persist(pessoaEntity);
		entityManager.flush();
		pessoaModel.setCodigo(pessoaEntity.getCodigo());
		entityManager.getTransaction().commit();
		
 
	}
 
	/***
	 * METODO PARA CONSULTAR A PESSOA
	 * @return
	 */
	
	public List<PessoaModel> getPessoas(){
 
		List<PessoaModel> pessoasModel = new ArrayList<PessoaModel>();
 
		entityManager = Uteis.EMF.createEntityManager();
		// entityManager =  Uteis.jpaEntityManager();
 
		Query query = entityManager.createNamedQuery("PessoaEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<PessoaEntity> pessoasEntity = (Collection<PessoaEntity>)query.getResultList();
 
		PessoaModel pessoaModel = null;
 
		for (PessoaEntity pessoaEntity : pessoasEntity) {
 
			pessoaModel = new PessoaModel();
			pessoaModel.setCodigo(pessoaEntity.getCodigo());
			pessoaModel.setDataCadastro(pessoaEntity.getDataCadastro());
			pessoaModel.setEmail(pessoaEntity.getEmail());
			pessoaModel.setEndereco(pessoaEntity.getEndereco());
			pessoaModel.setNome(pessoaEntity.getNome());
 
			if(pessoaEntity.getOrigemCadastro().equals("X"))
				pessoaModel.setOrigemCadastro("XML");
			else
				pessoaModel.setOrigemCadastro("INPUT");
 
 
			if(pessoaEntity.getSexo().equals("M"))
				pessoaModel.setSexo("Masculino");
			else
				pessoaModel.setSexo("Feminino");
 
			UsuarioEntity usuarioEntity =  pessoaEntity.getUsuarioEntity();			
 
			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel.setUsuario(usuarioEntity.getUsuario());
 
			pessoaModel.setUsuarioModel(usuarioModel);
 
			pessoasModel.add(pessoaModel);
		}
 
		return pessoasModel;
 
	}
	/***
	 * CONSULTA UMA PESSOA CADASTRADA PELO CODIGO
	 * @param codigo
	 * @return
	 */
	
	private PessoaEntity getPessoa(int codigo){
 
		entityManager = Uteis.EMF.createEntityManager();
		// entityManager =  Uteis.jpaEntityManager();
 
		return entityManager.find(PessoaEntity.class, codigo);
	}
 
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param pessoaModel
	 */
	
	public void alterar(PessoaModel pessoaModel){
 
		entityManager = Uteis.EMF.createEntityManager();
		// entityManager =  Uteis.jpaEntityManager();
 
		PessoaEntity pessoaEntity = this.getPessoa(pessoaModel.getCodigo());
 
		pessoaEntity.setEmail(pessoaModel.getEmail());
		pessoaEntity.setEndereco(pessoaModel.getEndereco());
		pessoaEntity.setNome(pessoaModel.getNome());
		pessoaEntity.setSexo(pessoaModel.getSexo());
 
		entityManager.merge(pessoaEntity);
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	
	public void excluir(int codigo){
 
		entityManager = Uteis.EMF.createEntityManager();
		// entityManager =  Uteis.jpaEntityManager();		
 
		PessoaEntity pessoaEntity = this.getPessoa(codigo);
 
		entityManager.remove(pessoaEntity);
	}
}