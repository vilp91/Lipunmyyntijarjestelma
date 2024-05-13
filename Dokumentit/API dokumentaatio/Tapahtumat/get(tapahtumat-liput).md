# Hae tapahtuman kaikki liput

Hakee kaikki tietokannassa olevat pyydettyyn tapahtumaan liittyvät liput tietoineen.

**URL**: `/tapahtumat/{id}/liput`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

## Onnistuneen pyynnön palautus

**Ehto**: Käyttäjän autentikointi onnistuu ja tapahtumaan on myyty lippuja

**Vastauskoodi**: `200 OK`

**Sisältöesimerkkejä**:

Haetaan liput.

```json
[
  {
    "lippunumero": "157934e5-189c-4076-9532-f6b1202b9ac7",
    "tapahtumanLipputyyppi": {
      "tapahtumanLipputyyppiId": 1,
      "hinta": 10.0,
      "tapahtuma": {
        "tapahtumanNimi": "Sukankudontakilpailu",
        "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
        "katuosoite": "Kuninkaantammentie 19",
        "alku": "2024-06-06T14:00:00",
        "loppu": "2024-06-06T16:00:00",
        "lippuLukum": 10,
        "myydytLiputLukum": 0,
        "tapahtuma_id": 1
      },
      "lipputyyppi": {
        "lipputyyppiId": 1,
        "tyyppi": "perus"
      }
    },
    "myyntitapahtuma": {
      "kayttaja": {
        "kayttajaId": 1,
        "rooli": {
          "rooliId": 1,
          "rooli": "ROLE_MYYJA"
        },
        "etunimi": "Teppo",
        "sukunimi": "Testaaja",
        "puhnro": null,
        "katuosoite": null,
        "salasana": "$2a$10$Yf1pwD1XzmI2bSilfoA1TOZ81v2fWrMdRU8qv6JOEqX6de6Vpzxyu",
        "kayttajanimi": "teppo"
      },
      "aikaleima": "2024-04-13T16:22:41.855274",
      "myyntitapahtuma_id": 1
    },
    "hinta": 10.0,
    "kaytetty": null,
    "lippu_id": 1
  },
  {
    "lippunumero": "6c3b3dc6-0378-431c-9b8e-dd7304a6236c",
    "tapahtumanLipputyyppi": {
      "tapahtumanLipputyyppiId": 1,
      "hinta": 10.0,
      "tapahtuma": {
        "tapahtumanNimi": "Sukankudontakilpailu",
        "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
        "katuosoite": "Kuninkaantammentie 19",
        "alku": "2024-06-06T14:00:00",
        "loppu": "2024-06-06T16:00:00",
        "lippuLukum": 10,
        "myydytLiputLukum": 0,
        "tapahtuma_id": 1
      },
      "lipputyyppi": {
        "lipputyyppiId": 1,
        "tyyppi": "perus"
      }
    },
    "myyntitapahtuma": {
      "kayttaja": {
        "kayttajaId": 1,
        "rooli": {
          "rooliId": 1,
          "rooli": "ROLE_MYYJA"
        },
        "etunimi": "Teppo",
        "sukunimi": "Testaaja",
        "puhnro": null,
        "katuosoite": null,
        "salasana": "$2a$10$Yf1pwD1XzmI2bSilfoA1TOZ81v2fWrMdRU8qv6JOEqX6de6Vpzxyu",
        "kayttajanimi": "teppo"
      },
      "aikaleima": "2024-04-13T16:22:41.855274",
      "myyntitapahtuma_id": 1
    },
    "hinta": 10.0,
    "kaytetty": null,
    "lippu_id": 2
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

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`

TAI

**Ehto**: Tapahtumaa ei ole olemassa

**Vastauskoodi**: `404 NOT FOUND`

**Sisältöesimerkki**:

Tehdään GET pyyntö /tapahtumat/30/liput endpointtiin. Saadaan seuraava vastaus:

```json
{
  "timestamp": "2024-05-13T10:40:41.301+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Tapahtumaa id:llä: '30' ei löytynyt",
  "path": "/tapahtumat/30/liput"
}
```
