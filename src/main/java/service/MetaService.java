package service;

import java.util.List;

import dto.MetaDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

public interface MetaService {

	MetaDTO incluir(MetaDTO metaDTO) throws ValidacaoException, ServicoException;

	MetaDTO alterar(MetaDTO metaDTO) throws ValidacaoException, ServicoException;

	MetaDTO inativar(Long id) throws ValidacaoException, ServicoException;

	List<MetaDTO> pesquisarMeta(Long idUsuario) throws ValidacaoException, ServicoException;

	MetaDTO detalheMeta(Long id) throws ValidacaoException, ServicoException;

}
