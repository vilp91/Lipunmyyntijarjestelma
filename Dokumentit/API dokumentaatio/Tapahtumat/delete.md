# Poista yksittäinen tapahtuman

Poistaa yksittäisen tapahtuman kaikkine tietoineen, kun tapahtumaan ei liity myytyjä lippuja ja käyttäjällä on vaadittavat oikeudet.

__URL__: `/tapahtumat/{id}`

__METODI__: `DELETE`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Admin

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `204 NO CONTENT`

## Epäonnistuneen pyynnön palautus

__Ehto__: {id} arvoa ei löydy tietokannasta.

__Vastauskoodi__: `404 NOT FOUND`

TAI

__Ehto__: tietokannassa on tapahtumaan myytyjä lippuja

__Vastauskoodi__: `400 BAD REQUEST`


TAI

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Vastauskoodi__: `403 FORBIDDEN`