package ServiceImplTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Constantes.MensagemErro;
import entity.Usuario;
import exceptions.ValidacaoException;
import repository.UsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UsuarioServiceImplTest {

	private static final Long ID = 1L;
	private static final String USUARIO = "Lucas";
	private static final String EMAIL = "lucas@teste.com";
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UsuarioRepository usuRepository;
	
	@Before
	public void preparaUsuario() throws ValidacaoException {
		createUsuario(1L, USUARIO);
	}
	
	@Test
	public void deveEncontrarUsuario() {
		assertEquals(ID, usuRepository.findById(1L).getId());
		assertEquals(USUARIO, usuRepository.findByLogin(USUARIO).getNome());
		assertEquals(EMAIL, usuRepository.findByEmail(EMAIL).getEmail());
	}
	
	@Test
	public void naoDeveEncontrarUsuario() {
		assertNotEquals(ID, usuRepository.findById(2L).getId());
		assertNotEquals(USUARIO, usuRepository.findByLogin("Luc").getLogin());
		assertNotEquals(EMAIL, usuRepository.findByEmail("lucas@").getEmail());
	}

	public void createUsuario(long id, String name) throws ValidacaoException {
		try {
			Usuario usuario = new Usuario();
			usuario.setId(id);
			usuario.setNome(name);
			Usuario usuSave = entityManager.merge(usuario);
			if(usuSave != usuario) {
				throw new ValidacaoException(MensagemErro.ERRO_TESTE.concat(MensagemErro.USUARIO));
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
