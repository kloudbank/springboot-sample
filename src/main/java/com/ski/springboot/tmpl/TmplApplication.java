package com.ski.springboot.tmpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TmplApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmplApplication.class, args);
	}

}
