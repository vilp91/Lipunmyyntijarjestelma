# Poista yksittäinen tapahtumanlipputyyppi

Poistaa yksittäisen tapahtumanlipputyypin kaikkine tietoineen.

__URL__: `/tapahtumanlipputyypit/{id}`

__METODI__: `DELETE`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Admin

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `204 NO CONTENT`

## Epäonnistuneen pyynnön palautus

__Ehto__: {id} -arvoa ei löydy tietokannasta

__Vastauskoodi__: `404 NOT FOUND`

TAI

__Ehto__: Autentikointi epäonnistuu

__Koodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Koodi__: `403 FORBIDDEN`