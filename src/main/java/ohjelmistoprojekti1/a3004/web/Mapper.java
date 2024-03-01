package ohjelmistoprojekti1.a3004.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import ohjelmistoprojekti1.a3004.domain.Kayttaja;
import ohjelmistoprojekti1.a3004.domain.Lippu;
import ohjelmistoprojekti1.a3004.domain.Myyntitapahtuma;
import ohjelmistoprojekti1.a3004.domain.Rooli;

//En tiedä tämän annotaation toimintoa täysin. -Ali
@Component
public class Mapper {

    public MyyntitapahtumaDTO toDTO(Myyntitapahtuma myyntitapahtuma) {
        Long id = myyntitapahtuma.getMyyntitapahtuma_id();
        String kayttaja = myyntitapahtuma.getKayttaja().getEtunimi() + " " + myyntitapahtuma.getKayttaja().getSukunimi();
        String kayttaja_rooli = myyntitapahtuma.getKayttaja().getRooli().getRooli();
        List<Lippu> liput = myyntitapahtuma.getLiput();
        LocalDateTime tapahtumaHetki = myyntitapahtuma.getAikaleima();
        return new MyyntitapahtumaDTO(id, kayttaja, kayttaja_rooli, liput, tapahtumaHetki);
    }

    public Myyntitapahtuma toMyyntitapahtuma(MyyntitapahtumaLuontiDTO myyntitapahtumaLuontiDTO) {
        Kayttaja kayttaja = new Kayttaja();
        kayttaja.setEtunimi(myyntitapahtumaLuontiDTO.getKayttaja().getEtunimi());
        kayttaja.setSukunimi(myyntitapahtumaLuontiDTO.getKayttaja().getSukunimi());

        Rooli rooli = new Rooli();
        rooli.setRooli(myyntitapahtumaLuontiDTO.getKayttaja().getRooli().getRooli());

        kayttaja.setRooli(rooli);
        kayttaja.setPuhnro(myyntitapahtumaLuontiDTO.getKayttaja().getPuhnro());
        kayttaja.setKatuosoite(myyntitapahtumaLuontiDTO.getKayttaja().getKatuosoite());

        LocalDateTime aikaleima = myyntitapahtumaLuontiDTO.getAikaleima();
        List<Lippu> liput = myyntitapahtumaLuontiDTO.getLiput();

        return new Myyntitapahtuma(myyntitapahtumaLuontiDTO.getKayttaja(), myyntitapahtumaLuontiDTO.getAikaleima(), myyntitapahtumaLuontiDTO.getLiput());
    }

}
