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
  "lippunumero": "441a7644-b6aa-4df8-808b-8e2d8dd16ccd",
  "tapahtumanLipputyyppi": {
    "tapahtumanLipputyyppiId": 37,
    "hinta": 25.0,
    "tapahtuma": {
      "tapahtumaId": 60,
      "tapahtumanNimi": "Karjumisen MM-kisat",
      "paikka": "Tokoinranta",
      "katuosoite": "Eläintarhantie 3",
      "alku": "2024-07-22T18:00:00",
      "loppu": "2024-07-22T21:00:00",
      "lippuLukum": 9999,
      "myydytLiputLukum": 43
    },
    "lipputyyppi": {
      "lipputyyppiId": 29,
      "tyyppi": "perus"
    }
  },
  "myyntitapahtuma": {
    "myyntitapahtumaId": 122,
    "kayttaja": {
      "kayttajaId": 29,
      "rooli": {
        "rooliId": 29,
        "rooli": "ROLE_MYYJA"
      },
      "etunimi": "Teppo",
      "sukunimi": "Testaaja",
      "puhnro": null,
      "katuosoite": null,
      "salasana": "$2a$10$7SdPXXL5nv/Zxy/jihLNZez20SUAl2gKh2OnS7ChIhclG/1aNAUPq",
      "kayttajanimi": "teppo"
    },
    "aikaleima": "2024-05-13T08:34:45.8146"
  },
  "hinta": 25.0,
  "kaytetty": null,
  "lippu_id": 272
}
```

## Epäonnistunut pyyntö

**Ehto**: Haetaan id:n perusteella lippua, mutta lippua haetulla id:llä ei ole olemassa.

**Vastauskoodi**: `404 NOT FOUND`

**Sisältöesimerkki**:

Tehdään GET pyyntö /liput/35 endpointtiin. Saadaan seuraava vastaus:

```json
{
  "timestamp": "2024-05-13T12:03:36.519+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Lippua syötetyllä id:llä: 35, ei löydy",
  "path": "/liput/35"
}
```

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Koodi**:: `403 FORBIDDEN`

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`
