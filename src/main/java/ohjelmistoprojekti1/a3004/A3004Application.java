package ohjelmistoprojekti1.a3004;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ohjelmistoprojekti1.a3004.domain.Kayttaja;
import ohjelmistoprojekti1.a3004.domain.KayttajaRepository;
import ohjelmistoprojekti1.a3004.domain.Lippu;
import ohjelmistoprojekti1.a3004.domain.LippuRepository;
import ohjelmistoprojekti1.a3004.domain.Lipputyyppi;
import ohjelmistoprojekti1.a3004.domain.LipputyyppiRepository;
import ohjelmistoprojekti1.a3004.domain.Myyntitapahtuma;
import ohjelmistoprojekti1.a3004.domain.MyyntitapahtumaRepository;
import ohjelmistoprojekti1.a3004.domain.Rooli;
import ohjelmistoprojekti1.a3004.domain.RooliRepository;
import ohjelmistoprojekti1.a3004.domain.Tapahtuma;
import ohjelmistoprojekti1.a3004.domain.TapahtumaRepository;
import ohjelmistoprojekti1.a3004.domain.TapahtumanLipputyyppi;
import ohjelmistoprojekti1.a3004.domain.TapahtumanLipputyyppiRepository;

@SpringBootApplication
public class A3004Application {

	public static void main(String[] args) {
		SpringApplication.run(A3004Application.class, args);
	}

	// lisätään demo data
	@Bean
	public CommandLineRunner demo(TapahtumaRepository tapahtumaRepository, MyyntitapahtumaRepository myyntitapahtumaRepository, KayttajaRepository kayttajaRepository, RooliRepository rooliRepository, LipputyyppiRepository lipputyyppiRepository, TapahtumanLipputyyppiRepository tapahtumanlipputyyppiRepository, LippuRepository lippuRepository) {
		// LocalDateTime nyt = LocalDateTime.now();

		return(args) -> {
			Tapahtuma tapahtuma1 = new Tapahtuma("Sukankudontakilpailu", "Pitkäkosken ulkoilumaja - Helsinki", "Kuninkaantammentie 19", LocalDateTime.of(2024,04,02, 14, 0), LocalDateTime.of(2024,04,02, 16, 0), 10);
			tapahtumaRepository.save(tapahtuma1);

			Tapahtuma tapahtuma2 = new Tapahtuma("Kekkosen synttärit", "Vaasa", "Vaasankatu 1", LocalDateTime.of(2024,03, 12, 17, 0), LocalDateTime.of(2024,03, 12, 23, 59), 667);
			tapahtumaRepository.save(tapahtuma2);

			Tapahtuma tapahtuma3 = new Tapahtuma("Cheek - Paluu areenalle", "Olympiastadion - Helsinki", "Paavo Nurmen tie 1", LocalDateTime.of(2031, 12, 22, 12, 30),LocalDateTime.of(2031, 12, 22, 14, 15), 9999);
			tapahtumaRepository.save(tapahtuma3);

			Tapahtuma tapahtuma4 = new Tapahtuma("Mysteeritapahtuma");
			tapahtumaRepository.save(tapahtuma4);

			Tapahtuma tapahtuma5 = new Tapahtuma("Karjumisen MM-kisat", "Tokoinranta", "Eläintarhantie 3", LocalDateTime.of(2024,02, 22, 18, 0), LocalDateTime.of(2024, 02, 22, 21, 0), 9999);
			tapahtumaRepository.save(tapahtuma5);

			Lipputyyppi lipputyyppi1 = new Lipputyyppi("Aikuinen", null);
			lipputyyppiRepository.save(lipputyyppi1);

			Lipputyyppi lipputyyppi2 = new Lipputyyppi("Lapsi", null);
			lipputyyppiRepository.save(lipputyyppi2);

			Lipputyyppi lipputyyppi3 = new Lipputyyppi("Opiskelija", null);
			lipputyyppiRepository.save(lipputyyppi3);

			Lipputyyppi lipputyyppi4 = new Lipputyyppi("Eläkeläinen", null);
			lipputyyppiRepository.save(lipputyyppi4);

			TapahtumanLipputyyppi tapahtumanLipputyyppi1 = new TapahtumanLipputyyppi(25.0, tapahtuma1, lipputyyppi1);
			tapahtumanlipputyyppiRepository.save(tapahtumanLipputyyppi1);

			Lippu lippu1 = new Lippu(tapahtumanLipputyyppi1, null, 25.0 );
			lippuRepository.save(lippu1);

			Rooli rooli1 = new Rooli("Admin", null);
			rooliRepository.save(rooli1);

			Rooli rooli2 = new Rooli("Myyjä", null);
			rooliRepository.save(rooli2);

			Kayttaja kayttaja1 = new Kayttaja(rooli2, null, "Matti", "Mattinen", "0700123123", "Matinkuja 420, Matinkylä");
			kayttajaRepository.save(kayttaja1);

			Myyntitapahtuma myyntitapahtuma1 = new Myyntitapahtuma(kayttaja1, LocalDate.of(2024, 03, 15), null); 
			myyntitapahtumaRepository.save(myyntitapahtuma1);

		};
	}

}
