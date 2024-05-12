# Hae tapahtuman kaikki myyntitapahtumat

Hakee kaikki tietokannassa olevat pyydettyyn tapahtumaan liittyvät myyntitapahtumat tietoineen

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

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Vastauskoodi__: `403 FORBIDDEN`

TAI

__Ehto__: Tapahtumaa ei ole olemassa

__Vastauskoodi__: `404 NOT FOUND`

__Sisältöesimerkki__: 

Tehdään GET pyyntö /tapahtumat/77/myyntitapahtuamt endpointtiin. Saadaan seuraava vastaus:

```json
{
...
    "message": "Tapahtumaa ei löydy annetulla id:llä '77'.",
...
}
```
