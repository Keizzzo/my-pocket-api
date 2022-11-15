package br.com.ozzziek.stoncksproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class StoncksProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoncksProjectApplication.class, args);
	}

	//Usado para corrigir timezone vinda do BD (UTC) para o JAVA (que era o GMT)
	@PostConstruct
	public void init(){
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

}
