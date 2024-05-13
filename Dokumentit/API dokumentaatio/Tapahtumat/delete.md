# Poista yksittäinen tapahtuman

Poistaa yksittäisen tapahtuman kaikkine tietoineen, kun tapahtumaan ei liity myytyjä lippuja ja käyttäjällä on vaadittavat oikeudet.

**URL**: `/tapahtumat/{id}`

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `204 NO CONTENT`

## Epäonnistuneen pyynnön palautus

**Ehto**: {id} arvoa ei löydy tietokannasta.

**Vastauskoodi**: `404 NOT FOUND`

**Esimerkkisisältö**:

```json
{
  "timestamp": "2024-05-13T10:57:56.049+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Tapahtumaa id:llä '10', ei löydy",
  "path": "/tapahtumat/10"
}
```

TAI

**Ehto**: tietokannassa on tapahtumaan myytyjä lippuja

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "timestamp": "2024-05-13T10:59:10.949+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Tapahtumaan on myyty lippuja, tapahtumaa ei voi poistaa.",
  "path": "/tapahtumat/57"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
