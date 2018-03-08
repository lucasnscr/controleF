package feign;


import dto.GerenciarUsuarioDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("/usuario")
public interface UsuarioFeignService {

    @RequestMapping(value="/gerenciarUsuarioFeign", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public GerenciarUsuarioDTO gerenciaDadosUsuarioFeign(@RequestParam("gerenciarUsuarioDTO") GerenciarUsuarioDTO gerenciarUsuarioDTO) throws ValidacaoException, ServicoException;

}
