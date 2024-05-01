# Hae kaikki myyntitapahtumat

Hakee ja näyttää kaikki tietokannassa olevat myyntitapahtumat saatavissa olevine tietoineen.

**URL**: `/myyntitapahtumat`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkejä**:

Haetaan kaikki tallennetut tapahtumat.

```json
[
    {
        "id": 1,
        "summa": 30.0,
        "aika": "2024-05-01T22:23:07.891687",
        "liput": [
            {
                "id": 1,
                "lippunumero": "21a02373-beb2-48f1-be96-582d85651cdb",
                "tyyppi": "perus",
                "tapahtuma": "Sukankudontakilpailu",
                "hinta": 15.0
            },
            {
                "id": 2,
                "lippunumero": "39a98e69-a22d-4dad-91dc-94c3bf676918",
                "tyyppi": "perus",
                "tapahtuma": "Sukankudontakilpailu",
                "hinta": 15.0
            }
        ],
        "kayttaja": {
            "kayttajaId": 1,
            "etunimi": "Teppo",
            "sukunimi": "Testaaja",
            "puhnro": null,
            "katuosoite": null
        }
    },
    {
        "id": 3,
        "summa": 30.0,
        "aika": "2024-05-01T22:23:23.175636",
        "liput": [
            {
                "id": 4,
                "lippunumero": "05ac48e6-2489-468f-8297-86c699da6f7a",
                "tyyppi": "perus",
                "tapahtuma": "Sukankudontakilpailu",
                "hinta": 15.0
            },
            {
                "id": 5,
                "lippunumero": "208c5061-cb4c-41ca-9bca-3a3b472a34c5",
                "tyyppi": "perus",
                "tapahtuma": "Sukankudontakilpailu",
                "hinta": 15.0
            }
        ],
        "kayttaja": {
            "kayttajaId": 2,
            "etunimi": "Heikki",
            "sukunimi": "Hallinnoija",
            "puhnro": null,
            "katuosoite": null
        }
    }
]
```

## Epäonnistuneen pyynnön palautus

**Vastauskoodi**: `404 NOT FOUND`

**Sisältöesimerkejä**:

Haetaan kaikki tallennetut tapahtumat, mutta listasta ei löydy tapahtumia (Ei hakutulosta).

```json

```

TAI

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Vastauskoodi__: `403 FORBIDDEN`