package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ohjelmistoprojekti1.a3004.domain.Kayttaja;
import ohjelmistoprojekti1.a3004.domain.KayttajaRepository;

@Component
public class DetailsService implements UserDetailsService {

    @Autowired
    KayttajaRepository kayttajat;

    @Override
    public UserDetails loadUserByUsername(String kayttajanimi) throws UsernameNotFoundException {

        Kayttaja kayttaja = kayttajat.findByKayttajanimi(kayttajanimi);
        if (kayttaja == null) {
            throw new UsernameNotFoundException("Käyttäjänimeä " + kayttajanimi + " ei löytynyt");
        }
        return new org.springframework.security.core.userdetails.User(
            kayttaja.getKayttajanimi(),
            kayttaja.getSalasana(),
            AuthorityUtils.createAuthorityList(kayttaja.getRooli().toString())
        );
    }
    
}
