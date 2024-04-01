# Hae yksittäisen lipun tiedot

Hakee lipun id:n perusteella yhden lipun.

**URL**: `/liput/{id}`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkki**:

Haetaan lipun tietoja id:n perusteella.

```json
{
  "lippu_id": 2,
  "tapahtuman_lipputyyppi": {
    "tapahtuman_lipputyyppi_id": 1,
    "hinta": 10.0,
    "tapahtuma": {
      "tapahtuma_id": 1,
      "tapahtuman_nimi": "Sukankudontakilpailu",
      "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
      "katuosoite": "Kuninkaantammentie 19",
      "alku": "2024-04-06T14:00:00",
      "loppu": "2024-04-06T16:00:00",
      "lippu_lukum": 10,
      "myydyt_liput_lukum": 0
    },
    "lipputyyppi": {
      "lipputyyppi_id": 1,
      "tyyppi": "perus"
    }
  },
  "myyntitapahtuma": {
    "myyntitapahtuma_id": 1,
    "kayttaja": {
      "kayttaja_id": 1,
      "rooli": {
        "rooli_id": 1,
        "rooli": "myyjä"
      },
      "etunimi": "Teppo",
      "sukunimi": "Testaaja",
      "puhnro": null,
      "katuosoite": null
    },
    "aikaleima": "2024-03-11T13:00:13.826432"
  },
  "hinta": 10.0
}
```

## Epäonnistunut pyyntö

**Ehto**: Haetaan id:n perusteella lippua, mutta lippua haetulla id:llä ei ole olemassa.

**Koodi**: `404 NOT FOUND`

TAI

**Ehto**: Autentikointi epäonnistuu

**Koodi**:: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Koodi**:: `403 FORBIDDEN`


**Sisältöesimerkki**:

Tehdään GET pyyntö /liput/35 endpointtiin. Saadaan seuraava vastaus:

```json
    "message": "Lippua syötetyllä id:llä: 35, ei löydy",
```
