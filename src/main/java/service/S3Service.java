package service;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;

public interface S3Service {
	
	S3Object downloadFile(String keyName);
	PutObjectResult uploadFile(String keyName, String uploadFilePath);

}
