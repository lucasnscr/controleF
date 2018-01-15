package service;

import dto.AlteraDadosUsuarioDTO;
import dto.CadastroUsuarioDTO;
import dto.GerenciarUsuarioDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

public interface UsuarioService {

	CadastroUsuarioDTO incluir(CadastroUsuarioDTO cadUsuarioDTO) throws ServicoException;

	AlteraDadosUsuarioDTO alterar(AlteraDadosUsuarioDTO alteraDadosUsuarioDTO) throws ValidacaoException, ServicoException;

	GerenciarUsuarioDTO inativar(Long id) throws ValidacaoException, ServicoException;

	GerenciarUsuarioDTO alteraEmail(GerenciarUsuarioDTO gerenciarUsuarioDTO) throws ValidacaoException, ServicoException;

	GerenciarUsuarioDTO alteraSenha(GerenciarUsuarioDTO gerenciarUsuarioDTO) throws ValidacaoException, ServicoException;

}
