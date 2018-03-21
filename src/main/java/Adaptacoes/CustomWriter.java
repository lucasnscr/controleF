package Adaptacoes;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import entity.CentroGastos;

public class CustomWriter implements ItemWriter<CentroGastos> {

	@Override
	public void write(List<? extends CentroGastos> items) throws Exception {

		System.out.println("Running Job..." + items.size());
		for (CentroGastos centroGastos : items) {
			System.out.println(centroGastos.getLancamentos());
		}

	}

}
