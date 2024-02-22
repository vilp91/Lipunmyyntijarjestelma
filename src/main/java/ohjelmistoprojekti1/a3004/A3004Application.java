package ohjelmistoprojekti1.a3004;

import java.time.LocalDateTime;

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
		LocalDateTime nyt = LocalDateTime.now();

		return(args) -> {
			Tapahtuma tapahtuma1 = new Tapahtuma("Sukankudontakilpailu", "Pitkäkosken ulkoilumaja - Helsinki", "Kuninkaantammentie 19", LocalDateTime.of(2024,04,02, 14, 0), LocalDateTime.of(2024,04,02, 16, 0), 50);
			tapahtumaRepository.save(tapahtuma1);

			Tapahtuma tapahtuma2 = new Tapahtuma("Kekkosen synttärit", "Vaasa", "Vaasankatu 1", LocalDateTime.of(2024,03, 12, 17, 0), LocalDateTime.of(2024,03, 12, 23, 59), 667);
			tapahtumaRepository.save(tapahtuma2);

			Tapahtuma tapahtuma3 = new Tapahtuma("Cheek - Paluu areenalle", "Olympiastadion - Helsinki", "Paavo Nurmen tie 1", LocalDateTime.of(2031, 12, 22, 0, 0),LocalDateTime.of(2031, 12, 22, 0, 0), 9999);
			tapahtumaRepository.save(tapahtuma3);

			Tapahtuma tapahtuma4 = new Tapahtuma("Mysteeritapahtuma");
			tapahtumaRepository.save(tapahtuma4);

			Tapahtuma tapahtuma5 = new Tapahtuma("Karjumisen MM-kisat", "Tokoinranta", "Eläintarhantie 3", LocalDateTime.of(2024,02, 22, 18, 0), LocalDateTime.of(2024, 02, 22, 21, 0), 9999);
			tapahtumaRepository.save(tapahtuma5);
		};
	}

}
