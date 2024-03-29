# Poista yksittäinen myyntitapahtuma

Poistaa yksittäisen myyntitapahtuman ja siihen liittyvät liput.

__URL__: `/myyntitapahtumat/{id}`

__METODI__: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Ei mitään

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `204 NO CONTENT`

## Epäonnistuneen pyynnön palautus

__Ehto__: {id} -arvoa ei löydy tietokannasta

__Vastauskoodi__: `404 NOT FOUND`

TAI

__Ehto__: Autentikointi epäonnistuu

__Koodi__: `401 UNAUTHORIZED`