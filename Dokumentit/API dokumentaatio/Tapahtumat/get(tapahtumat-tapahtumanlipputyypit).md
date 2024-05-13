# Hae yksittäisen tapahtuman tapahtumanlipputyypit

Hakee kaikki tietokannassa olevat lipputyypit, jotka liittyvät määritettyyn tapahtumaan.

**URL**: `/tapahtumat/{id}/tapahtumanlipputyypit`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Ehto**: Autentikointi onnistuu ja käyttäjälle näytetään tulokset.

**Vastauskoodi**: `200 OK`

**Esimerkkisisältö**:

```json
[
  {
    "id": 2,
    "hinta": 10.0,
    "tapahtuma": 2,
    "lipputyyppiId": 1,
    "lipputyyppi": "perus"
  }
]
```

TAI

**Ehto**: Autentikointi onnistuu ja tapahtumaan ei ole liitetty tapahtumanlipputyyppejä.

**Vastauskoodi**: `200 OK`

**Sisältö**: `[]`

## Epäonnistuneen pyynnön palautus

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`

TAI

**Ehto**: Tapahtumaa ei ole olemassa

**Vastauskoodi**: `404 NOT FOUND`

**Sisältöesimerkki**:

Tehdään GET pyyntö /tapahtumat/30/liput endpointtiin. Saadaan seuraava vastaus:

```json
{
  "timestamp": "2024-05-13T10:48:14.617+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Tapahtumaa id:llä '30' ei löytynyt",
  "path": "/tapahtumat/30/tapahtumanlipputyypit"
}
```
