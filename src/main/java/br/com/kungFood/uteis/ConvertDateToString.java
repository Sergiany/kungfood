package br.com.kungFood.uteis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertDateToString {

	public String convertDateInsert(String data) {

		SimpleDateFormat formatoRecebido = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		SimpleDateFormat mascaraData = new SimpleDateFormat("yyyy-MM-dd");

		Date novoFormato = null;
		String dataFormatada = null;

		try {
			novoFormato = formatoRecebido.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		dataFormatada = mascaraData.format(novoFormato);

		return dataFormatada;
	}

	public String convertDateSelect(String data) {

		SimpleDateFormat formatoRecebido = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		SimpleDateFormat mascaraData = new SimpleDateFormat("dd/MM/yyyy");

		Date novoFormato = null;
		String dataFormatada = null;

		try {
			novoFormato = formatoRecebido.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		dataFormatada = mascaraData.format(novoFormato);

		return dataFormatada;
	}
}