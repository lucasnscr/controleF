package service;

import java.util.List;

import dto.EnderecoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

public interface EnderecoService {

	EnderecoDTO incluir(EnderecoDTO enderecoDTO) throws ValidacaoException, ServicoException;

	EnderecoDTO alterar(EnderecoDTO enderecoDTO) throws ValidacaoException, ServicoException;

	EnderecoDTO inativar(Long id) throws ValidacaoException, ServicoException;

	List<EnderecoDTO> listarEnderecoUsuario(Long id) throws ValidacaoException, ServicoException;

	EnderecoDTO detalharEndereco(Long id) throws ValidacaoException, ServicoException;

}
