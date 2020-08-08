package com.tonyvonwolfe.terra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TerraApplication {

	public final int THREADPOOL_QUEUE_CAPACITY = 500;

	public static void main(String[] args) {
		SpringApplication.run(TerraApplication.class, args);
	}

}
