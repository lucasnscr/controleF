package resource;

import org.springframework.beans.factory.annotation.Autowired;
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
import service.S3Service;

@Api
@RestController
@RequestMapping("/s3")
public class S3Resource {

	@Autowired
	private S3Service s3Service;

	@RequestMapping(value="/upload", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public PutObjectResult upload(PutObjectRequest putObjectRequest)
			throws SdkClientException, AmazonServiceException {
		PutObjectResult uploadFile = s3Service.uploadFile(putObjectRequest.getBucketName(), putObjectRequest.getFile().getAbsolutePath());
		return uploadFile;

	}

	@RequestMapping(value="/download", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public S3Object download(GetObjectRequest getObjectRequest) throws SdkClientException, AmazonServiceException {
		S3Object downloadFile = s3Service.downloadFile(getObjectRequest.getKey());
		return downloadFile;
	}

}