package factoryConnection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import serviceImpl.S3ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class S3Connection {

	private Logger logger = LoggerFactory.getLogger(S3ServiceImpl.class);
	
	@Value("${jsa.aws.access_key_id}")
	private static final String awsId = "";

	@Value("${jsa.aws.secret_access_key}")
	private static final String awsKey = "";

	@Value("${jsa.s3.region}")
	private String region;

	@Bean
	public AmazonS3 s3client() {

		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region))
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
		
		String bucketName = "controlef";
		 
		if(s3Client.doesBucketExist(bucketName)) {
			logger.info("Bucket name is not available."
		      + " Try again with a different Bucket name.");
		}
		 
		s3Client.createBucket(bucketName);

		return s3Client;
	}
}
