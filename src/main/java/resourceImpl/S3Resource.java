package resourceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;

import service.S3Service;

public class S3Resource implements resource.S3Resource {

	@Autowired
	private S3Service s3Service;

	public PutObjectResult upload(PutObjectRequest putObjectRequest)
			throws SdkClientException, AmazonServiceException {
		PutObjectResult uploadFile = s3Service.uploadFile(putObjectRequest.getBucketName(), putObjectRequest.getFile().getAbsolutePath());
		return uploadFile;

	}

	public S3Object download(GetObjectRequest getObjectRequest) throws SdkClientException, AmazonServiceException {
		S3Object downloadFile = s3Service.downloadFile(getObjectRequest.getKey());
		return downloadFile;
	}

}