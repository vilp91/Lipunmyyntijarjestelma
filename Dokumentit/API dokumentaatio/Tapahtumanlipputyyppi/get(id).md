# Hae yksittäinen tapahtumanlipputyyppi

Hakee tapahtumanlipputyypin id:n perusteella yhden tapahtumanlipputyypin.

**URL**: `/tapahtumanlipputyypit/{id}`

**Metodi**: `GET`

__Autentikointi vaaditaan__: Kyllä

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
...
    "message": "Tapahtumanlipputyyppiä ei löytynyt id:llä '7'.",
...
}
```

TAI

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Vastauskoodi__: `403 FORBIDDEN`