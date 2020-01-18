package pl.com.example.bankappmicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BankAppMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppMicroApplication.class, args);
	}

}
