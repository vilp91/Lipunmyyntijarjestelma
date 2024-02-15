package ohjelmistoprojekti1.a3004;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ohjelmistoprojekti1.a3004.domain.Tapahtuma;
import ohjelmistoprojekti1.a3004.domain.TapahtumaRepository;

@SpringBootApplication
public class A3004Application {

	public static void main(String[] args) {
		SpringApplication.run(A3004Application.class, args);
	}

	// lisätään demo data
	@Bean
	public CommandLineRunner demo(TapahtumaRepository tapahtumaRepository) {
		LocalDate nyt = LocalDate.now();

		return(args) -> {
			Tapahtuma tapahtuma1 = new Tapahtuma("Tapahtuma1", "Helsinki", "Testikatu 1", nyt, nyt, 200);
			tapahtumaRepository.save(tapahtuma1);
		};
	}

}
