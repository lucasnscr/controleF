package main;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import entity.Usuario;
import enums.FlagAtivo;
import repository.UsuarioRepository;
import validacoes.ValidacoesImpl;

@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private ValidacoesImpl validacoes;
	
	@Autowired
	public DataLoader(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		Usuario usuario =  new Usuario();
		usuario.setId(1L);
		usuario.setDocumento("12345678");
		usuario.setRendimentoMensal(9.000);
		usuario.setEmail("lucas@teste.com");
		Date dataNascimento = Date.from(Instant.parse("27051994"));
		usuario.setDataNascimento(dataNascimento);
		LocalDate now = LocalDate.now();
		usuario.setCadastro(now);
		usuario.setAtualizacao(now);
		usuario.setAtivo(FlagAtivo.ATIVO.valor);
		usuario.setLogin("lucasnscr");
		usuario.setSenha("abcdefg");
		Long geraChave = validacoes.geraChave();
		usuario.setChave(geraChave);
		repository.save(new Usuario());
		
	}
}


