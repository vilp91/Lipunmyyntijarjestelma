# Poista yksittäinen myyntitapahtuma

Poistaa yksittäisen myyntitapahtuman kaikkine tietoineen.

__URL__: `/myyntitapahtumat/{id}`

__METODI__: `DELETE`

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `204 NO CONTENT`

## Epäonnistuneen pyynnön palautus

__Ehto__: {id} -arvoa ei löydy tietokannasta

__Vastauskoodi__: `404 NOT FOUND`