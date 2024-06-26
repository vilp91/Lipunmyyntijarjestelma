package ohjelmistoprojekti1.a3004;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

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
	 @Profile("dev")
	public CommandLineRunner demo(TapahtumaRepository tapahtumaRepository, LipputyyppiRepository lipputyyppiRepository,
        TapahtumanLipputyyppiRepository tapahtumanLipputyyppiRepository, LippuRepository lippuRepository, RooliRepository rooliRepository,
        KayttajaRepository kayttajaRepository, MyyntitapahtumaRepository myyntitapahtumaRepository, DataSource dataSource) {

			return(args) -> {
				String[] sqlStatements = {
						"DELETE FROM lippu",
						"DELETE FROM myyntitapahtuma",
						"DELETE FROM kayttaja",
						"DELETE FROM rooli",
						"DELETE FROM tapahtuman_lipputyyppi",
						"DELETE FROM lipputyyppi",
						"DELETE FROM tapahtuma"
				};
				try (Connection connection = dataSource.getConnection()) {
					Statement statement = connection.createStatement();
					for (String sql : sqlStatements) {
						statement.executeUpdate(sql);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			Tapahtuma tapahtuma1 = new Tapahtuma("Sukankudontakilpailu", "Pitkäkosken ulkoilumaja - Helsinki", "Kuninkaantammentie 19", LocalDateTime.of(2024,06,06, 14, 0), LocalDateTime.of(2024,06,06, 16, 0), 10);
			tapahtuma1.setMyydytLiputLukum(3);
			tapahtumaRepository.save(tapahtuma1);

			Tapahtuma tapahtuma2 = new Tapahtuma("Kekkosen synttärit", "Vaasa", "Vaasankatu 1", LocalDateTime.of(2024,06, 12, 17, 0), LocalDateTime.of(2024,06, 12, 23, 59), 667);
			tapahtumaRepository.save(tapahtuma2);

			Tapahtuma tapahtuma3 = new Tapahtuma("Cheek - Paluu areenalle", "Olympiastadion - Helsinki", "Paavo Nurmen tie 1", LocalDateTime.of(2031, 12, 22, 12, 30),LocalDateTime.of(2031, 12, 22, 14, 15), 9999);
			tapahtumaRepository.save(tapahtuma3);

			Tapahtuma tapahtuma5 = new Tapahtuma("Karjumisen MM-kisat", "Tokoinranta", "Eläintarhantie 3", LocalDateTime.of(2024,07, 22, 18, 0), LocalDateTime.of(2024, 07, 22, 21, 0), 9999);
			tapahtumaRepository.save(tapahtuma5);

			Lipputyyppi lipputyyppi1 = new Lipputyyppi("perus");
			Lipputyyppi lipputyyppi2 = new Lipputyyppi("lapsi");
			Lipputyyppi lipputyyppi3 = new Lipputyyppi("opiskelija");
			Lipputyyppi lipputyyppi4 = new Lipputyyppi("eläkeläinen");
			lipputyyppiRepository.save(lipputyyppi1);
			lipputyyppiRepository.save(lipputyyppi2);
			lipputyyppiRepository.save(lipputyyppi3);
			lipputyyppiRepository.save(lipputyyppi4);

			TapahtumanLipputyyppi tapahtumanLipputyyppi1 = new TapahtumanLipputyyppi();
			tapahtumanLipputyyppi1.setHinta(15);
			tapahtumanLipputyyppi1.setTapahtuma(tapahtuma1);
			tapahtumanLipputyyppi1.setLipputyyppi(lipputyyppi1);
			tapahtumanLipputyyppiRepository.save(tapahtumanLipputyyppi1);

			TapahtumanLipputyyppi tapahtumanLipputyyppi2 = new TapahtumanLipputyyppi();
			tapahtumanLipputyyppi2.setHinta(8);
			tapahtumanLipputyyppi2.setTapahtuma(tapahtuma1);
			tapahtumanLipputyyppi2.setLipputyyppi(lipputyyppi2);
			tapahtumanLipputyyppiRepository.save(tapahtumanLipputyyppi2);

			TapahtumanLipputyyppi tapahtumanLipputyyppi3 = new TapahtumanLipputyyppi();
			tapahtumanLipputyyppi3.setHinta(20);
			tapahtumanLipputyyppi3.setTapahtuma(tapahtuma2);
			tapahtumanLipputyyppi3.setLipputyyppi(lipputyyppi1);
			tapahtumanLipputyyppiRepository.save(tapahtumanLipputyyppi3);

			TapahtumanLipputyyppi tapahtumanLipputyyppi4 = new TapahtumanLipputyyppi();
			tapahtumanLipputyyppi4.setHinta(10);
			tapahtumanLipputyyppi4.setTapahtuma(tapahtuma2);
			tapahtumanLipputyyppi4.setLipputyyppi(lipputyyppi2);
			tapahtumanLipputyyppiRepository.save(tapahtumanLipputyyppi4);

			TapahtumanLipputyyppi tapahtumanLipputyyppi5 = new TapahtumanLipputyyppi();
			tapahtumanLipputyyppi5.setHinta(10);
			tapahtumanLipputyyppi5.setTapahtuma(tapahtuma2);
			tapahtumanLipputyyppi5.setLipputyyppi(lipputyyppi4);
			tapahtumanLipputyyppiRepository.save(tapahtumanLipputyyppi5);

			TapahtumanLipputyyppi tapahtumanLipputyyppi6 = new TapahtumanLipputyyppi();
			tapahtumanLipputyyppi6.setHinta(60);
			tapahtumanLipputyyppi6.setTapahtuma(tapahtuma3);
			tapahtumanLipputyyppi6.setLipputyyppi(lipputyyppi1);
			tapahtumanLipputyyppiRepository.save(tapahtumanLipputyyppi6);

			TapahtumanLipputyyppi tapahtumanLipputyyppi7 = new TapahtumanLipputyyppi();
			tapahtumanLipputyyppi7.setHinta(50);
			tapahtumanLipputyyppi7.setTapahtuma(tapahtuma3);
			tapahtumanLipputyyppi7.setLipputyyppi(lipputyyppi3);
			tapahtumanLipputyyppiRepository.save(tapahtumanLipputyyppi7);

			Rooli rooli1 = new Rooli();
			rooli1.setRooli("ROLE_MYYJA");
			rooliRepository.save(rooli1);

			Rooli rooli2 = new Rooli();
			rooli2.setRooli("ROLE_ADMIN");
			rooliRepository.save(rooli2);

			Kayttaja kayttaja1 = new Kayttaja();
			kayttaja1.setEtunimi("Teppo");
			kayttaja1.setSukunimi("Testaaja");
			kayttaja1.setRooli(rooli1);
			kayttaja1.setKayttajanimi("teppo");
			kayttaja1.setSalasana("salasana");
			kayttajaRepository.save(kayttaja1);

			Kayttaja kayttaja2 = new Kayttaja();
			kayttaja2.setEtunimi("Heikki");
			kayttaja2.setSukunimi("Hallinnoija");
			kayttaja2.setRooli(rooli2);
			kayttaja2.setKayttajanimi("heikki");
			kayttaja2.setSalasana("salaisempisana");
			kayttajaRepository.save(kayttaja2);

			Myyntitapahtuma myyntitapahtuma1 = new Myyntitapahtuma();
			myyntitapahtuma1.setKayttaja(kayttaja1);
			myyntitapahtumaRepository.save(myyntitapahtuma1);

			Myyntitapahtuma myyntitapahtuma2 = new Myyntitapahtuma();
			myyntitapahtuma2.setKayttaja(kayttaja1);
			myyntitapahtumaRepository.save(myyntitapahtuma2);

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

			Lippu lippu3 = new Lippu();
			lippu3.setTapahtuman_lipputyyppi(tapahtumanLipputyyppi2);
			lippu3.setHinta(tapahtumanLipputyyppi1.getHinta());
			lippu3.setMyyntitapahtuma(myyntitapahtuma2);
			lippuRepository.save(lippu3);
		};
	} 

}
