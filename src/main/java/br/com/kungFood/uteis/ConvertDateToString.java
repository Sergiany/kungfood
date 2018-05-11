package br.com.kungFood.uteis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class ConvertDateToString {

	@Test
	public String convertDateInsert(String data) {
		SimpleDateFormat formatoRecebido = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy", Locale.ENGLISH);
		SimpleDateFormat mascaraData = new SimpleDateFormat("dd-MM-yyyy");
		Date novoFormato = null;
		String dataFormatada = null;
		if (data.length() > 10) {
			try {
				novoFormato = formatoRecebido.parse(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dataFormatada = mascaraData.format(novoFormato);
		}
		return dataFormatada;
	}
}