package main;

import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;

import dto.AnaliseLancamentoDTO;
import dto.LancamentoDTO;

public class teste {
	
	/**
	 * O método diferencaDatas e calcularDiferencaHora é para 
	 * @param analise
	 * @return
	 */
	
	private Long diferencaDatas(AnaliseLancamentoDTO analise) {
		//Método para converter Date em localDate
		LocalDate inicio = toLocalDate(analise.getInicio());
		LocalDate fim = toLocalDate(analise.getFim());
		
		//Usando a biblioteca ChronoUnit para obter a diferença de dias
		Long diferenca = ChronoUnit.DAYS.between(inicio, fim);
		
		//Usando a bilbioteca period para pegar diferenças de datas
		Period periodo = Period.between(inicio,fim);
		
		//Obtendo a quantidade de anos
		int ano = periodo.getYears();
		
		//Obtendo a quantidade de meses
		int meses = periodo.getMonths();
		
		//Obtendo a quantidade de dias
		int dias = periodo.getDays();
		
		return diferenca;
	}
	
	private Long calcularDiferencaHora(AnaliseLancamentoDTO analise) {
		LocalTime horaInicio = analise.getHorasEstudoInicio();
		LocalTime horaFim = analise.getHorasEstudoFim();
		Long diferenca = ChronoUnit.HOURS.between(horaInicio, horaFim);
		return diferenca;
	}
	
	private Long converteStringNum(LancamentoDTO lancamento) throws UnsupportedEncodingException {
		
		String descricao = lancamento.getDescricao();
		descricao = "-123";
		
		//O método NumberUtils#isParsable(String) consegue verificar apenas inteiros 
		//em sistema decimal e pontos flutuantes. 
		
		boolean eNumero = NumberUtils.isParsable(descricao);
		if(eNumero) {
			int parseInt = Integer.parseInt(descricao);
			System.out.println(parseInt);
		}
		
		String [] numeros = {".5", "3.08", "-9d", "7e2", "3.4e1", "5e-2", ".3f", "-6", "2L", "0xFF", "06", "+077",
		        "4_000", "0b1010", "-Infinity", "NaN"};
		
		for (String num : numeros) {
			boolean eNumero2 = NumberUtils.isCreatable(num);
			if(eNumero2) {
				System.out.println(num + "\t" + NumberUtils.createNumber(num));
			}else {
				System.out.println("Não conseguiu converter" + num);
			}
		}
		
		//transformando stringo em base64
		String teste1 = "aaa";
		String teste = Base64.getEncoder().encodeToString(teste1.getBytes("UTF-8"));
		
		System.out.println(teste);
		
		return null;

	}
	
	private LocalDate toLocalDate(Date d) {
		Instant instant = Instant.ofEpochMilli(d.getTime());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	}

}
