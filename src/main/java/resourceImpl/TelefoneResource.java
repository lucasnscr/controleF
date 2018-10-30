package resourceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dto.TelefoneDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import service.TelefoneService;

public class TelefoneResource implements resource.TelefoneResource {

	@Autowired
	private TelefoneService telefoneService;
	
    public TelefoneDTO insert(TelefoneDTO telefoneDTO)  throws ValidacaoException, ServicoException {
		TelefoneDTO endDTO = telefoneService.incluir(telefoneDTO);
        return endDTO;
    }

    public TelefoneDTO alterar (TelefoneDTO telefoneDTO)  throws ValidacaoException, ServicoException {
    	TelefoneDTO endDTO = telefoneService.alterar(telefoneDTO);
        return endDTO;
    }

    public TelefoneDTO inativar(Long id)  throws ValidacaoException, ServicoException{
    	TelefoneDTO endDTO = telefoneService.inativar(id);
    	return endDTO;
    }
	
    public List<TelefoneDTO> listarTelefoneUsuario(Long idUsuario)  throws ValidacaoException, ServicoException{
    	List<TelefoneDTO> endDTOList = telefoneService.listarTelefoneUsuario(idUsuario);
    	return endDTOList;
    }
    
    public TelefoneDTO detalharTelefone(Long id)  throws ValidacaoException, ServicoException{
    	TelefoneDTO endDTO = telefoneService.detalharTelefone(id);
    	return endDTO;
    }
	
}
