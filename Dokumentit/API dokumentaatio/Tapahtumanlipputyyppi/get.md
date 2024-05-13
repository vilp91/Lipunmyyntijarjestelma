# Hae kaikki tapahtumanlipputyypit

Hakee kaikki luodut tapahtumanlipputyypit.

**URL**: `/tapahtumanlipputyypit`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkki**:

```json
[
  {
    "tapahtumanLipputyyppiId": 29,
    "hinta": 10.0,
    "tapahtuma": {
      "tapahtumaId": 57,
      "tapahtumanNimi": "Sukankudontakilpailu",
      "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
      "katuosoite": "Kuninkaantammentie 19",
      "alku": "2024-06-06T14:00:00",
      "loppu": "2024-06-06T16:00:00",
      "lippuLukum": 10,
      "myydytLiputLukum": 0
    },
    "lipputyyppi": {
      "lipputyyppiId": 29,
      "tyyppi": "perus"
    }
  },
  {
    "tapahtumanLipputyyppiId": 30,
    "hinta": 10.0,
    "tapahtuma": {
      "tapahtumaId": 58,
      "tapahtumanNimi": "Kekkosen synttärit",
      "paikka": "Vaasa",
      "katuosoite": "Vaasankatu 1",
      "alku": "2024-06-12T17:00:00",
      "loppu": "2024-06-12T23:59:00",
      "lippuLukum": 667,
      "myydytLiputLukum": 35
    },
    "lipputyyppi": {
      "lipputyyppiId": 29,
      "tyyppi": "perus"
    }
  },
  {
    "tapahtumanLipputyyppiId": 31,
    "hinta": 5.0,
    "tapahtuma": {
      "tapahtumaId": 57,
      "tapahtumanNimi": "Sukankudontakilpailu",
      "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
      "katuosoite": "Kuninkaantammentie 19",
      "alku": "2024-06-06T14:00:00",
      "loppu": "2024-06-06T16:00:00",
      "lippuLukum": 10,
      "myydytLiputLukum": 0
    },
    "lipputyyppi": {
      "lipputyyppiId": 30,
      "tyyppi": "lapsi"
    }
  }
]
```

**Epäonnistuneen pyynnön palautus**

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
