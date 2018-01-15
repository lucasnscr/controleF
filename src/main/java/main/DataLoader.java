package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class DataLoader implements ApplicationRunner{

	
	@Autowired
	public DataLoader() {
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
	}
}
