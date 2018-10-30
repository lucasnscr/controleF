package resourceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dto.EnderecoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import service.EnderecoService;

public class EnderecoResource implements  resource.EnderecoResource{
	
	@Autowired
	private EnderecoService enderecoService;
	
    public EnderecoDTO insert(EnderecoDTO enderecoDTO)  throws ValidacaoException, ServicoException {
		EnderecoDTO endDTO = enderecoService.incluir(enderecoDTO);
        return endDTO;
    }

    public EnderecoDTO alterar (EnderecoDTO enderecoDTO)  throws ValidacaoException, ServicoException {
    	EnderecoDTO endDTO = enderecoService.alterar(enderecoDTO);
        return endDTO;
    }

    public EnderecoDTO inativar(Long id)  throws ValidacaoException, ServicoException{
    	EnderecoDTO endDTO = enderecoService.inativar(id);
    	return endDTO;
    }
	
    public List<EnderecoDTO> listarEnderecoUsuario(Long idUsuario)  throws ValidacaoException, ServicoException{
    	List<EnderecoDTO> endDTOList = enderecoService.listarEnderecoUsuario(idUsuario);
    	return endDTOList;
    }
    
    public EnderecoDTO detalharEndereco(Long id)  throws ValidacaoException, ServicoException{
    	EnderecoDTO endDTO = enderecoService.detalharEndereco(id);
    	return endDTO;
    }
}
