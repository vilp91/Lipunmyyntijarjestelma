# Hae yksittäinen tapahtumanlipputyyppi

Hakee tapahtumanlipputyypin id:n perusteella yhden tapahtumanlipputyypin.

**URL**: `/tapahtumanlipputyypit/{id}`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkki**:

```json
{
  "id": 1,
  "hinta": 10.0,
  "tapahtuma": 1,
  "lipputyyppiId": 1,
  "lipputyyppi": "perus"
}
```

## Epäonnistuneen pyynnön palautus

**Ehto**: Haetaan id:n perusteella tapahtumanlipputyyppiä, mutta tapahtumanlipputyyppiä haetulla id:llä ei ole olemassa.

**Vastauskoodi**: `404 NOT FOUND`

**Sisältöesimerkki**:

Tehdään GET pyyntö /tapahtumanlipputyypit/7 endpointtiin. Saadaan seuraava vastaus:

```json
{
  "timestamp": "2024-05-13T12:19:30.065+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Tapahtumanlipputyyppiä ei löytynyt id:llä '7'.",
  "path": "/tapahtumanlipputyypit/7"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
