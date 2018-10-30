package resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value= "ControleF - Planilhas de gasto")
@RestController
@RequestMapping("/s3")
public interface S3Resource {


	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Ok"),
			@ApiResponse(code = 400, message="Bad Request"),
			@ApiResponse(code = 404, message="Not Found"),
			@ApiResponse(code = 500, message="Internal Server Error")
	})
	
	@ApiOperation(value = "Serviço que insere uma planilha")
	@ApiResponse(code= 200, message="upload realizado com sucesso")
	@RequestMapping(value="/upload", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public PutObjectResult upload(PutObjectRequest putObjectRequest)
			throws SdkClientException, AmazonServiceException;

	@ApiOperation(value = "Serviço que baixa uma planilha inserida")
	@ApiResponse(code= 200, message="download realizado com sucesso")
	@RequestMapping(value="/download", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public S3Object download(GetObjectRequest getObjectRequest) throws SdkClientException, AmazonServiceException;

}