package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControleFApplication{

	public static final Logger log = LoggerFactory.getLogger(ControleFApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ControleFApplication.class, args);
	}
}
