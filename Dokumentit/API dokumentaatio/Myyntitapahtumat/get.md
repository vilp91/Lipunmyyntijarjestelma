# Hae kaikki myyntitapahtumat

Hakee ja näyttää kaikki tietokannassa olevat myyntitapahtumat saatavissa olevine tietoineen.

**URL**: `/myyntitapahtumat`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkejä**:

Haetaan kaikki tallennetut myyntitapahtumat.

```json
[
  {
    "id": 1,
    "summa": 30.0,
    "aika": "2024-05-11T22:53:55.533059",
    "kayttajaId": 1,
    "liput": [
      {
        "id": 1,
        "lippunumero": "462378c1-88f0-414d-b8ea-c550aedff67a",
        "tyyppi": "perus",
        "tapahtuma": "Sukankudontakilpailu",
        "hinta": 15.0
      },
      {
        "id": 2,
        "lippunumero": "6f4a8413-7927-40e7-99e2-e932e580925e",
        "tyyppi": "perus",
        "tapahtuma": "Sukankudontakilpailu",
        "hinta": 15.0
      }
    ]
  },
  {
    "id": 2,
    "summa": 15.0,
    "aika": "2024-05-11T22:53:55.533849",
    "kayttajaId": 1,
    "liput": [
      {
        "id": 3,
        "lippunumero": "d3aa169c-6109-49ec-864c-b6d96ee62faf",
        "tyyppi": "lapsi",
        "tapahtuma": "Sukankudontakilpailu",
        "hinta": 15.0
      }
    ]
  }
]
```

## Epäonnistuneen pyynnön palautus

**Vastauskoodi**: `404 NOT FOUND`

**Sisältöesimerkejä**:

Haetaan kaikki tallennetut myyntitapahtumat, mutta listasta ei löydy myyntitapahtumia (Ei hakutulosta).

```json

```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
