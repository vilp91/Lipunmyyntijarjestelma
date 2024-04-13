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
        "summa": 20.0,
        "aika": "2024-04-13T13:51:56.100065",
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
        "id": 3,
        "summa": 50.0,
        "aika": "2024-04-13T13:53:33.395816",
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
            },
            {
                "id": 6,
                "tyyppi": "perus",
                "tapahtuma": "Sukankudontakilpailu",
                "hinta": 10.0
            },
            {
                "id": 7,
                "tyyppi": "perus",
                "tapahtuma": "Sukankudontakilpailu",
                "hinta": 10.0
            },
            {
                "id": 8,
                "tyyppi": "perus",
                "tapahtuma": "Sukankudontakilpailu",
                "hinta": 10.0
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
