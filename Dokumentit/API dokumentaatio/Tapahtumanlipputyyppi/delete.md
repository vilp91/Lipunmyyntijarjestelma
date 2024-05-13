# Poista yksittäinen tapahtumanlipputyyppi

Poistaa yksittäisen tapahtumanlipputyypin kaikkine tietoineen.

**URL**: `/tapahtumanlipputyypit/{id}`

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `204 NO CONTENT`

## Epäonnistuneen pyynnön palautus

**Ehto**: {id} -arvoa ei löydy tietokannasta

**Vastauskoodi**: `404 NOT FOUND`

**Esimerkkisisältö**:

```json
{
  "timestamp": "2024-05-13T12:31:35.016+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Tapahtumanlipputyyppiä id:llä '1' ei löydy",
  "path": "/tapahtumanlipputyypit/1"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
