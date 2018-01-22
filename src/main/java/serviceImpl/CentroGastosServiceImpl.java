package serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import dto.CentroGastosDTO;
import entity.CentroGastos;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import repository.CentroGastosRepository;
import service.CentroGastosService;
import validacoes.ValidacoesImpl;

public class CentroGastosServiceImpl implements CentroGastosService {

	@Autowired
	private CentroGastosRepository centroGastosRepository;
	
	@Autowired
	private ValidacoesImpl validacao;
	
	@Override
	public CentroGastosDTO pesquisarCentroGastosUsuario(Long idUsuario) throws ValidacaoException, ServicoException {
		try {
			validacao.validaUsuario(idUsuario);
			CentroGastos centroGastos = centroGastosRepository.findByIdUsuario(idUsuario);
			if(centroGastos != null) {
				CentroGastosDTO centroGastosDTO =  null;
				BeanUtils.copyProperties(centroGastos, centroGastosDTO);
				return centroGastosDTO;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
}
