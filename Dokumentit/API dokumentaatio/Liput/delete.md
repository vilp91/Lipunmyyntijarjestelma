# Poista yksittäinen lippu

Poistaa yksittäisen lipun ja päivittää tapahtumaan myytyjen lippujen määrän.

**URL**: `/liput/{id}`

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin tai Myyjä

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `204 NO CONTENT`

## Epäonnistuneen pyynnön palautus

**Ehto**: {id} -arvoa ei löydy tietokannasta

**Vastauskoodi**: `404 NOT FOUND`

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
