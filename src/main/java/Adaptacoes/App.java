package Adaptacoes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		String springConfig = "spring/batch/jobs/job-report.xml";
		ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext(springConfig);
		
	}

}
