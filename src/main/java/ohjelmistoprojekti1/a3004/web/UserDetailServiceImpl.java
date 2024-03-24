package ohjelmistoprojekti1.a3004.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti1.a3004.domain.Kayttaja;
import ohjelmistoprojekti1.a3004.domain.KayttajaRepository;

/**
 * This class is used by spring security to authenticate and authorize user
 *
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    KayttajaRepository kayttajaRepository;

    @Override
    public UserDetails loadUserByUsername(String kayttajatunnus) throws UsernameNotFoundException {
        Kayttaja nykyinenKayttaja = kayttajaRepository.findByKayttajatunnus(kayttajatunnus);
        if (nykyinenKayttaja == null) {
            throw new UsernameNotFoundException(kayttajatunnus + " ei löydy");
        }
        UserDetails user = new org.springframework.security.core.userdetails.User(kayttajatunnus, nykyinenKayttaja.getSalasanaHash(),
                AuthorityUtils.createAuthorityList(nykyinenKayttaja.getRooli().getRooli()));
        return user;
    }
}
