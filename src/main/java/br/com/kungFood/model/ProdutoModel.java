package br.com.kungFood.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProdutoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String descrição;
	private double valor;
	private double quantidade;
	private String validade;
	
	public ProdutoModel() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		System.out.println(convertDate(validade));
		this.validade = convertDate(validade);
	}
	
	public String convertDate(String data) {
		SimpleDateFormat formatoRecebido = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy", Locale.ENGLISH); 
		SimpleDateFormat mascaraData=new SimpleDateFormat("yyyy-MM-dd");
		Date novoFormato = null;
		try {
			novoFormato = formatoRecebido.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dataFormatada = mascaraData.format(novoFormato);
		return dataFormatada;
	}
	

}
