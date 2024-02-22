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
			Tapahtuma tapahtuma1 = new Tapahtuma("Sukankudontakilpailu", "Pitkäkosken ulkoilumaja - Helsinki", "Kuninkaantammentie 19", LocalDate.of(2024,04,02), LocalDate.of(2024,04,02), 50);
			tapahtumaRepository.save(tapahtuma1);

			Tapahtuma tapahtuma2 = new Tapahtuma("Kekkosen synttärit", "Vaasa", "Vaasankatu 1", nyt, nyt, 667);
			tapahtumaRepository.save(tapahtuma2);

			Tapahtuma tapahtuma3 = new Tapahtuma("Cheek - Paluu areenalle", "Olympiastadion - Helsinki", "Paavo Nurmen tie 1", LocalDate.of(2031, 12, 22),LocalDate.of(2031, 12, 22), 9999);
			tapahtumaRepository.save(tapahtuma3);

			Tapahtuma tapahtuma4 = new Tapahtuma("Mysteeritapahtuma");
			tapahtumaRepository.save(tapahtuma4);
		};
	}

}
