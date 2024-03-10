# Hae kaikki myyntitapahtumat

Hakee ja näyttää kaikki tietokannassa olevat myyntitapahtumat saatavissa olevine tietoineen.

**URL**: `/myyntitapahtumat`

**Metodi**: `GET`

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkejä**:

Haetaan kaikki tallennetut tapahtumat.

```json
[
  {
    "id": 1,
    "summa": 20.0,
    "aika": "2024-03-04T17:02:57.902103",
    "liput": [
      {
        "id": 1,
        "tyyppi": "perus",
        "tapahtuma": "Sukankudontakilpailu",
        "hinta": 10.0
      },
      {
        "id": 2,
        "tyyppi": "perus",
        "tapahtuma": "Sukankudontakilpailu",
        "hinta": 10.0
      }
    ]
  },
  {
    "id": 2,
    "summa": 10.0,
    "aika": "2024-03-04T17:02:57.905106",
    "liput": [
      {
        "id": 3,
        "tyyppi": "perus",
        "tapahtuma": "Kekkosen synttärit",
        "hinta": 10.0
      }
    ]
  },
  {
    "id": 3,
    "summa": 20.0,
    "aika": "2024-03-04T17:05:29.236237",
    "liput": [
      {
        "id": 4,
        "tyyppi": "perus",
        "tapahtuma": "Sukankudontakilpailu",
        "hinta": 10.0
      },
      {
        "id": 5,
        "tyyppi": "perus",
        "tapahtuma": "Sukankudontakilpailu",
        "hinta": 10.0
      }
    ]
  }
]
```

## Epäonnistuneen pyynnön palautus

**Vastauskoodi**: `404 NOT FOUND`

**Sisältöesimerkejä**:

Haetaan kaikki tallennetut tapahtumat, mutta listasta ei löydy tapahtumia (Ei haku tulosta).

```json

```
