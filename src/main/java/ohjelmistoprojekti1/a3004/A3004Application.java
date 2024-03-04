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
	public CommandLineRunner demo(TapahtumaRepository tapahtumaRepository, LipputyyppiRepository lipputyyppiRepository,
	TapahtumanLipputyyppiRepository tapahtumanLipputyyppiRepository, LippuRepository lippuRepository, RooliRepository rooliRepository,
	KayttajaRepository kayttajaRepository, MyyntitapahtumaRepository myyntitapahtumaRepository) {
		// LocalDateTime nyt = LocalDateTime.now();

		return(args) -> {
			Tapahtuma tapahtuma1 = new Tapahtuma("Sukankudontakilpailu", "Pitkäkosken ulkoilumaja - Helsinki", "Kuninkaantammentie 19", LocalDateTime.of(2024,04,02, 14, 0), LocalDateTime.of(2024,04,02, 16, 0), 50);
			tapahtumaRepository.save(tapahtuma1);

			Tapahtuma tapahtuma2 = new Tapahtuma("Kekkosen synttärit", "Vaasa", "Vaasankatu 1", LocalDateTime.of(2024,03, 12, 17, 0), LocalDateTime.of(2024,03, 12, 23, 59), 667);
			tapahtumaRepository.save(tapahtuma2);

			Tapahtuma tapahtuma3 = new Tapahtuma("Cheek - Paluu areenalle", "Olympiastadion - Helsinki", "Paavo Nurmen tie 1", LocalDateTime.of(2031, 12, 22, 12, 30),LocalDateTime.of(2031, 12, 22, 14, 15), 9999);
			tapahtumaRepository.save(tapahtuma3);

			Tapahtuma tapahtuma4 = new Tapahtuma("Mysteeritapahtuma");
			tapahtumaRepository.save(tapahtuma4);

			Tapahtuma tapahtuma5 = new Tapahtuma("Karjumisen MM-kisat", "Tokoinranta", "Eläintarhantie 3", LocalDateTime.of(2024,02, 22, 18, 0), LocalDateTime.of(2024, 02, 22, 21, 0), 9999);
			tapahtumaRepository.save(tapahtuma5);

			Lipputyyppi lipputyyppi1 = new Lipputyyppi("perus");
			Lipputyyppi lipputyyppi2 = new Lipputyyppi("lapsi");
			lipputyyppiRepository.save(lipputyyppi1);
			lipputyyppiRepository.save(lipputyyppi2);

			TapahtumanLipputyyppi tapahtumanLipputyyppi1 = new TapahtumanLipputyyppi();
			tapahtumanLipputyyppi1.setHinta(10);
			tapahtumanLipputyyppi1.setTapahtuma(tapahtuma1);
			tapahtumanLipputyyppi1.setLipputyyppi(lipputyyppi1);
			tapahtumanLipputyyppiRepository.save(tapahtumanLipputyyppi1);

			Rooli rooli1 = new Rooli();
			rooli1.setRooli("myyjä");
			rooliRepository.save(rooli1);

			Kayttaja kayttaja1 = new Kayttaja();
			kayttaja1.setEtunimi("Teppo");
			kayttaja1.setSukunimi("Testaaja");
			kayttaja1.setRooli(rooli1);
			kayttajaRepository.save(kayttaja1);

			Myyntitapahtuma myyntitapahtuma1 = new Myyntitapahtuma();
			myyntitapahtuma1.setKayttaja(kayttaja1);
			myyntitapahtumaRepository.save(myyntitapahtuma1);

			Lippu lippu1 = new Lippu();
			lippu1.setTapahtuman_lipputyyppi(tapahtumanLipputyyppi1);
			lippu1.setHinta(tapahtumanLipputyyppi1.getHinta());
			lippu1.setMyyntitapahtuma(myyntitapahtuma1);
			lippuRepository.save(lippu1);

			Lippu lippu2 = new Lippu();
			lippu2.setTapahtuman_lipputyyppi(tapahtumanLipputyyppi1);
			lippu2.setHinta(tapahtumanLipputyyppi1.getHinta());
			lippu2.setMyyntitapahtuma(myyntitapahtuma1);
			lippuRepository.save(lippu2);
		};
	}

}
