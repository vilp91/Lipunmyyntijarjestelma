# Hae tapahtuman kaikki liput

Hakee kaikki tietokannassa olevat pyydettyyn tapahtumaan liittyvät liput tietoineen

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
    "lippu_id": 1,
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
      "aikaleima": "2024-03-11T13:11:20.715442"
    },
    "hinta": 10.0
  },
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
      "aikaleima": "2024-03-11T13:11:20.715442"
    },
    "hinta": 10.0
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

Tehdään GET pyyntö /tapahtumat/30/liput endpointtiin. Saadaan seuraava vastaus:

```json
{
...
    "message": "Tapahtumaa id:llä: '30' ei löytynyt",
...
}
```