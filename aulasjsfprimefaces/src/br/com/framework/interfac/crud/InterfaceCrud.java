package br.com.framework.interfac.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface InterfaceCrud<T> extends Serializable{

	// salva os dados
	void save(T obj) throws Exception;
	
	void persist(T obj) throws Exception;
	
	// salva ou atualiza
	void saveOrUpdate(T obj) throws Exception;
	
	// realiza o update dos dados
	void update(T obj) throws Exception;
	
	// realiza a exclusão dos dados
	void delete(T obj) throws Exception;
	
	// salva ou atualiza e retorna objeto em estado persistente
	T merge (T obj) throws Exception;
	
	// carrega a lista de dados de determinada classe
	List<T> findList(Class<T> objs) throws Exception;
	
	// Busca entidades por ID
	Object findById(Class<T> entidade, Long id) throws Exception;
	
	T findByPorId(Class<T> entidade, Long id) throws Exception;
	
	// Busca entidades usando query dinâmica
	List<T> findListByQueryDinamica(String s) throws Exception;
	
	// Executa update usando HQL
	void executeUpdateQueryDinamica(String s) throws Exception;
	
	// Executa update usando SQL
	void executeUpdateSQLDinamica(String s) throws Exception;
	
	// Limpar sessão do hibernate
	void clearSession() throws Exception;
	
	// Retira um objeto da sessão do hibernate
	void evict(Object objs) throws Exception;
	
	// Retorna a sessão do hibernate
	Session getSession() throws Exception;
	
	List<?> getListSQLDinamica(String sql) throws Exception;
	
	
	// JDBC do Spring
	JdbcTemplate getJdbcTemplate();
	
	SimpleJdbcTemplate getSimpleJdbcTemplate();
	
	SimpleJdbcInsert getSimpleJdbcInsert();
	
	
	// Retorna o total de registro de uma tabela
	Long getTotalRegistros(String tabela) throws Exception;
	
	// Fazer montagem dinâmica de SQL/Query para consulta de dados
	Query obterQuery(String query) throws Exception;
	
	// Carregamento dinâmico co JSF e Primefaces
	List<T> findListByQueryDinamica(String query, int inicialNoRegistro, int maximoResuldato) throws Exception;
}
