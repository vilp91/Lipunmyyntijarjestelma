package ohjelmistoprojekti1.a3004.RepositoryTests;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import jakarta.transaction.Transactional;
import ohjelmistoprojekti1.a3004.domain.Lipputyyppi;
import ohjelmistoprojekti1.a3004.domain.LipputyyppiRepository;

@DataJpaTest
@Transactional
@Rollback(true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class LipputyyppiTests {

    @Autowired
    LipputyyppiRepository lipputyyppiRepository;

    // testaa uuden lipputyypin luomista ja hakua tietokannasta
    @Test
    public void LipputyyppiLuontiTest() {

        // luo uusi lipputyyppi ja tallenna se tietokantaan 
        Lipputyyppi testiLipputyyppi = new Lipputyyppi("Mister Tester");
        lipputyyppiRepository.save(testiLipputyyppi);

        // hae tallennettu lipputyyppi
        Lipputyyppi tallennettuLipputyyppi = lipputyyppiRepository.findByTyyppi("Mister Tester");

        // tarkista, että tallennettu lipputyyppi ei ole tyhjä ja sisältö vastaa oletettua
        assertNotNull(tallennettuLipputyyppi);
        assertEquals("Mister Tester", tallennettuLipputyyppi.getTyyppi());

    }

    // testaa lipputyypin tietojen päivittämistä
    @Test
    public void LipputyyppiPaivitysTest() {

        // luo uusi lipputyyppi ja tallenna se tietokantaan 
        Lipputyyppi testiLipputyyppi = new Lipputyyppi("Mister Tester");
        lipputyyppiRepository.save(testiLipputyyppi);

        // päivitä tietoja ja tallenna uudestaan tietokantaan
        testiLipputyyppi.setTyyppi("Just Tester");
        lipputyyppiRepository.save(testiLipputyyppi);

        // hae lipputyyppi tietokannasta ja tarkista tietojen päivittyminen
        Optional<Lipputyyppi> testattavaLipputyyppi = lipputyyppiRepository.findById(testiLipputyyppi.getLipputyyppiId());
        assertEquals("Just Tester", testattavaLipputyyppi.get().getTyyppi());
        assertNotEquals("Mister Tester", testattavaLipputyyppi.get().getTyyppi());

    }
}
