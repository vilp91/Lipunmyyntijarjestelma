package ohjelmistoprojekti1.a3004.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import ohjelmistoprojekti1.a3004.domain.Lippu;
import ohjelmistoprojekti1.a3004.domain.Myyntitapahtuma;

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
        return new Myyntitapahtuma(myyntitapahtumaLuontiDTO.getKayttaja(), myyntitapahtumaLuontiDTO.getAikaleima(), myyntitapahtumaLuontiDTO.getLiput());
    }

}
