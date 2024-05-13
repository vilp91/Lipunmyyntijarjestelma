# Hae käyttäjät

Hakee kaikki tietokannassa olevat käyttäjät tietoineen

**URL**: `/kayttajat`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkkejä**:

Haetaan käyttäjät.

```json
[
  {
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
  {
    "kayttajaId": 30,
    "rooli": {
      "rooliId": 30,
      "rooli": "ROLE_ADMIN"
    },
    "etunimi": "Heikki",
    "sukunimi": "Hallinnoija",
    "puhnro": null,
    "katuosoite": null,
    "salasana": "$2a$10$KZC10rsr6Ea29WL.lCAXzu2hwGoy5CpmdTX44lnxR78PEDx236ytO",
    "kayttajanimi": "heikki"
  },
  {
    "kayttajaId": 31,
    "rooli": {
      "rooliId": 31,
      "rooli": "ROLE_LIPUNTARKASTAJA"
    },
    "etunimi": "Lauri",
    "sukunimi": "Lipunmyyjä",
    "puhnro": "0700123123",
    "katuosoite": null,
    "salasana": "$2a$10$fDmaB.poCxr0j9Mw3R4YCe5aRKh3QSJKlKO0Mw8BNIv5m084zgmL2",
    "kayttajanimi": "lauri"
  }
]
```

## Epäonnistunut pyyntö

**Ehto**: Autentikointi epäonnistuu

**Koodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Koodi**: `403 FORBIDDEN`
