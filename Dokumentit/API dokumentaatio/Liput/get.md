# Hae liput

Hakee ja näyttää tietokannassa olevat liput tietoineen.

**URL**: `/liput`

**Parametrit**: "lippunumero" - palauttaa lippunumeroa vastaavan lipun tietoineen. Ei pakollinen

esim. `/liput?lippunumero=1b23ed76-6a05-428b-ae3d-264f8a0c2676`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä, Admin tai Lipuntarkastaja

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkkejä**:

Haetaan liput ilman parametria

```json
[
  {
    "lippunumero": "1b23ed76-6a05-428b-ae3d-264f8a0c2676",
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
        "myydytLiputLukum": 2,
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
        "salasana": "$2a$10$iWu9jKWk.x4BVFHzO/FNTu1PZ5qX0cAy2HtwS05bHBgG8OxBhDA3C",
        "kayttajanimi": "teppo"
      },
      "aikaleima": "2024-04-12T23:11:14.775349",
      "myyntitapahtuma_id": 1
    },
    "hinta": 10.0,
    "kaytetty": null,
    "lippu_id": 2
  },
  {
    "lippunumero": "17db01d4-a2fd-45af-b3f0-cbd9b1269878",
    "tapahtumanLipputyyppi": {
      "tapahtumanLipputyyppiId": 2,
      "hinta": 10.0,
      "tapahtuma": {
        "tapahtumanNimi": "Kekkosen synttärit",
        "paikka": "Vaasa",
        "katuosoite": "Vaasankatu 1",
        "alku": "2024-06-12T17:00:00",
        "loppu": "2024-06-12T23:59:00",
        "lippuLukum": 667,
        "myydytLiputLukum": 0,
        "tapahtuma_id": 2
      },
      "lipputyyppi": {
        "lipputyyppiId": 1,
        "tyyppi": "perus"
      }
    },
    "myyntitapahtuma": {
      "kayttaja": null,
      "aikaleima": "2024-04-12T23:11:14.776349",
      "myyntitapahtuma_id": 2
    },
    "hinta": 10.0,
    "kaytetty": null,
    "lippu_id": 3
  }
]
```

Haetaan parametrilla yksi lippu

```json
[
  {
    "lippunumero": "1b23ed76-6a05-428b-ae3d-264f8a0c2676",
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
        "myydytLiputLukum": 2,
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
        "salasana": "$2a$10$iWu9jKWk.x4BVFHzO/FNTu1PZ5qX0cAy2HtwS05bHBgG8OxBhDA3C",
        "kayttajanimi": "teppo"
      },
      "aikaleima": "2024-04-12T23:11:14.775349",
      "myyntitapahtuma_id": 1
    },
    "hinta": 10.0,
    "kaytetty": null,
    "lippu_id": 2
  }
]
```

## Epäonnistunut pyyntö

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**:: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`

TAI

**Ehto**: Parametrilla ei löydy lippua

**Vastauskoodi**: `404 NOT FOUND`

TAI

**Ehto**: Pyynnössä oleva parametri jätetään tyhjäksi

**Sisältöesimerkki**: `/liput?lippunumero=`

**Vastauskoodi**: `400 BAD REQUEST`
