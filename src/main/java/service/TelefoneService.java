package service;

import java.util.List;

import dto.TelefoneDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

public interface TelefoneService {

	TelefoneDTO incluir(TelefoneDTO telefoneDTO) throws ValidacaoException, ServicoException;

	TelefoneDTO alterar(TelefoneDTO telefoneDTO) throws ValidacaoException, ServicoException;

	TelefoneDTO inativar(Long id) throws ValidacaoException, ServicoException;

	List<TelefoneDTO> listarTelefoneUsuario(Long idUsuario) throws ValidacaoException, ServicoException;

	TelefoneDTO detalharTelefone(Long id) throws ValidacaoException, ServicoException;

}
