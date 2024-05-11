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
    "aika": "2024-05-11T22:54:44.783189",
    "kayttajaId": 1,
    "liput": [
        {
            "id": 1,
            "lippunumero": "99932afc-f2cc-4c5a-ab20-4829f7d888f6",
            "tyyppi": "perus",
            "tapahtuma": "Sukankudontakilpailu",
            "hinta": 15.0
        },
        {
            "id": 2,
            "lippunumero": "db9790c3-f91c-4d15-b094-1976c6f9f23e",
            "tyyppi": "perus",
            "tapahtuma": "Sukankudontakilpailu",
            "hinta": 15.0
        }
    ]
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