# Hae yksittäinen myyntitapahtuma

Hakee myyntitapahtuman id:n perusteella yhden myyntitapahtuman.

**URL**: `/myyntitapahtumat/{id}`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkejä**:

Haetaan myyntitapahtuma id:n perusteella.

```json
{
    "id": 1,
    "summa": 30.0,
    "aika": "2024-05-01T22:14:33.967931",
    "liput": [
        {
            "id": 1,
            "lippunumero": "25cdf11c-07b9-442e-be72-049398ae2937",
            "tyyppi": "perus",
            "tapahtuma": "Sukankudontakilpailu",
            "hinta": 15.0
        },
        {
            "id": 2,
            "lippunumero": "e9d4d952-be3d-4f90-86bb-a6bdbd0a07a9",
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
```

## Epäonnistunut pyyntö

**Ehto**: Haetaan id:n perusteella myyntitapahtumaa, mutta myyntitapahtumaa haetulla id:llä ei ole olemassa.

**Vastauskoodi**: `404 NOT FOUND`

**Sisältöesimerkki**:

Tehdään GET pyyntö /myyntitapahtumat/10 endpointtiin. Saadaan seuraava vastaus:

```json
{
...
    "message": "Myyntitapahtumaa syötetyllä id:llä '10'', ei löydy",
...
}
```

TAI

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Vastauskoodi__: `403 FORBIDDEN`