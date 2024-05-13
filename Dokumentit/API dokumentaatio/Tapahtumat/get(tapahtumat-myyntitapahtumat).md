# Hae tapahtuman kaikki myyntitapahtumat

Hakee kaikki tietokannassa olevat pyydettyyn tapahtumaan liittyvät myyntitapahtumat tietoineen.

**URL**: `/tapahtumat/{id}/myyntitapahtumat`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin tai myyjä

## Onnistuneen pyynnön palautus

**Ehto**: Käyttäjän autentikointi onnistuu ja tapahtumalla on myyntitapahtumia

**Vastauskoodi**: `200 OK`

**Sisältöesimerkkejä**:

Haetaan myyntitapahtumia.

```json
[
  {
    "id": 1,
    "summa": 30.0,
    "aika": "2024-05-11T23:03:52.351743",
    "kayttajaId": 1,
    "liput": [
      {
        "id": 1,
        "lippunumero": "f50c2ad9-d144-4b73-936e-b663140322a2",
        "tyyppi": "perus",
        "tapahtuma": "Sukankudontakilpailu",
        "hinta": 15.0
      },
      {
        "id": 2,
        "lippunumero": "1edc2786-2d24-4d39-8b35-c747a9b3952e",
        "tyyppi": "perus",
        "tapahtuma": "Sukankudontakilpailu",
        "hinta": 15.0
      }
    ]
  },
  {
    "id": 2,
    "summa": 15.0,
    "aika": "2024-05-11T23:03:52.352743",
    "kayttajaId": 1,
    "liput": [
      {
        "id": 3,
        "lippunumero": "286e91bc-e869-4aa4-bc79-d7fac754ceee",
        "tyyppi": "lapsi",
        "tapahtuma": "Sukankudontakilpailu",
        "hinta": 15.0
      }
    ]
  },
  {
    "id": 3,
    "summa": 30.0,
    "aika": "2024-05-11T23:04:11.256708",
    "kayttajaId": 2,
    "liput": [
      {
        "id": 4,
        "lippunumero": "1f6e7d9d-5bd1-4473-ae0c-8aaaf92497ed",
        "tyyppi": "perus",
        "tapahtuma": "Sukankudontakilpailu",
        "hinta": 15.0
      },
      {
        "id": 5,
        "lippunumero": "01e9eca7-07ea-4ef9-8f23-d9ac8efe3584",
        "tyyppi": "perus",
        "tapahtuma": "Sukankudontakilpailu",
        "hinta": 15.0
      }
    ]
  }
]
```

TAI

**Vastauskoodi**: `200 OK`

**Ehto**: Autentikointi onnistuu, mutta tapahtumaan ei ole myyty lippuja

**Sisältöesimerkkejä**:

```json
[]
```

## Epäonnistunut pyyntö

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`

TAI

**Ehto**: Tapahtumaa ei ole olemassa

**Vastauskoodi**: `404 NOT FOUND`

**Sisältöesimerkki**:

Tehdään GET pyyntö /tapahtumat/77/myyntitapahtumat endpointtiin. Saadaan seuraava vastaus:

```json
{
  "timestamp": "2024-05-13T10:50:09.425+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Tapahtumaa ei löydy annetulla id:llä '77'.",
  "path": "/tapahtumat/77/myyntitapahtumat"
}
```
