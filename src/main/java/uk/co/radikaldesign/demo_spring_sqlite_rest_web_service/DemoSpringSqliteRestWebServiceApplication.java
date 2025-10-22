package uk.co.radikaldesign.demo_spring_sqlite_rest_web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "controllers", "services", "config" })
@EntityScan(basePackages = { "models" })
@EnableJpaRepositories(basePackages = "repos")
public class DemoSpringSqliteRestWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringSqliteRestWebServiceApplication.class, args);
	}

}
