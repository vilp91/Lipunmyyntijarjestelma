# Hae yksittäisen lipputyypin tiedot

Hakee lipputyypin id:n perusteella yhden lipputyypin.

**URL**: `/lipputyypit/{id}`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkki**:

Haetaan lipputyypin tietoja id:n perusteella.

```json
{
  "lipputyyppi_id": 1,
  "tyyppi": "perus"
}
```

## Epäonnistuneen pyynnön palautus

**Ehto**: Haetaan id:n perusteella lipputyyppiä, mutta lipputyyppiä haetulla id:llä ei ole olemassa.

**Vastauskoodi**: `404 NOT FOUND`

**Sisältöesimerkki**:

Tehdään GET pyyntö /lipputyypit/3 endpointtiin. Saadaan seuraava vastaus:

```json
{
...
    "message": "Lipputyyppiä id:llä 3 ei löydy",
...
}
```

TAI

**Ehto**: Haetaan id:n perusteella lipputyyppiä, joka on poistettu.

**Vastauskoodi**: `404 NOT FOUND`

```json
    "message": "Lipputyyppi id:llä 1 on poistettu",
```

TAI

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Vastauskoodi__: `403 FORBIDDEN`