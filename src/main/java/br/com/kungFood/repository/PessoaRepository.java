package br.com.kungFood.repository;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import br.com.kungFood.model.PessoaModel;
import br.com.kungFood.uteis.Uteis;
import br.com.kungFood.entity.PessoaEntity;

public class PessoaRepository {

	@Inject
	PessoaEntity pessoaEntity;

	EntityManager entityManager;

	/***
	 * METODO RESPONSAVEL POR SALVAR UMA NOVA PESSOA
	 * 
	 * @param pessoaModel
	 */
	public void salvar(PessoaModel pessoaModel) {

		entityManager = Uteis.getConexao();
		entityManager.getTransaction().begin();

		pessoaEntity = new PessoaEntity();
		//pessoaEntity.setDataCadastro(LocalDateTime.now());
		pessoaEntity.setEmail(pessoaModel.getEmail());
		pessoaEntity.setEndereco(pessoaModel.getEndereco());
		pessoaEntity.setNome(pessoaModel.getNome());
		pessoaEntity.setSexo(pessoaModel.getSexo());

		entityManager.persist(pessoaEntity);
		entityManager.flush();
		pessoaModel.setCodigo(pessoaEntity.getCodigo());
		//pessoaModel.setDataCadastro(pessoaEntity.getDataCadastro());
		entityManager.getTransaction().commit();

	}

	public PessoaEntity findPessoa(Integer id) {
		return entityManager.find(PessoaEntity.class, id);
	}
	/***
	 * METODO PARA CONSULTAR A PESSOA
	 * 
	 * @return
	 */

	public List<PessoaModel> getPessoas() {

		List<PessoaModel> pessoasModel = new ArrayList<PessoaModel>();

		entityManager = Uteis.getConexao();

		Query query = entityManager.createNamedQuery("PessoaEntity.findAll");

		@SuppressWarnings("unchecked")
		Collection<PessoaEntity> pessoasEntity = (Collection<PessoaEntity>) query.getResultList();

		PessoaModel pessoaModel = null;

		for (PessoaEntity pessoaEntity : pessoasEntity) {

			pessoaModel = new PessoaModel();
			pessoaModel.setCodigo(pessoaEntity.getCodigo());
			pessoaModel.setDataCadastro(pessoaEntity.getDataCadastro());
			pessoaModel.setEmail(pessoaEntity.getEmail());
			pessoaModel.setEndereco(pessoaEntity.getEndereco());
			pessoaModel.setNome(pessoaEntity.getNome());



			if (pessoaEntity.getSexo().equals("M"))
				pessoaModel.setSexo("Masculino");
			else
				pessoaModel.setSexo("Feminino");

			pessoasModel.add(pessoaModel);
		}

		return pessoasModel;

	}

	/***
	 * CONSULTA UMA PESSOA CADASTRADA PELO CODIGO
	 * 
	 * @param codigo
	 * @return
	 */

	private PessoaEntity getPessoa(int codigo) {

		entityManager = Uteis.getConexao();

		return entityManager.find(PessoaEntity.class, codigo);
	}

	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param pessoaModel
	 */
	
	public void alterar(PessoaModel pessoaModel) throws ParseException {
		
		try {

			PessoaEntity pessoaEntity = this.getPessoa(pessoaModel.getCodigo());
	 
			pessoaEntity.setEmail(pessoaModel.getEmail());
			pessoaEntity.setEndereco(pessoaModel.getEndereco());
			pessoaEntity.setNome(pessoaModel.getNome());
			pessoaEntity.setSexo(pessoaModel.getSexo());
	 
			entityManager = Uteis.getConexao();
			entityManager.getTransaction().begin();			
			//pessoaModel.setCodigo(pessoaEntity.getCodigo());
			entityManager.merge(pessoaEntity);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if(msg == null || msg.length() == 0) {
				Integer id = pessoaModel.getCodigo();
				if (findPessoa(id) == null) {

					System.out.println("Pessoa nao encontrada");
				}
			}
			throw ex;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}


	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * 
	 * @param codigo
	 */

	public void excluir(int codigo) {
		try {
			entityManager = Uteis.getConexao();
			entityManager.getTransaction().begin();
			PessoaEntity pessoa = new PessoaEntity();
			try {
				pessoa = entityManager.getReference(PessoaEntity.class, codigo);
				pessoa.getCodigo();
			} catch (EntityNotFoundException enfe) {
				
			}
			entityManager.remove(pessoa);
			entityManager.getTransaction().commit();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
}