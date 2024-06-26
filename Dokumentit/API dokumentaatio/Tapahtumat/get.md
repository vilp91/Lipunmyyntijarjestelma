# Hae kaikki tapahtumat

Hakee ja näyttää kaikki tietokannassa olevat tapahtumat saatavissa olevine tietoineen.

**URL**: `/tapahtumat`

**Vapaaehtoiset parametrit**: "alkaen" - haetaan tapahtumat annetusta hetkestä alkaen, "paattyen" - haetaan tapahtumat annettuun hetkeen saakka

esim. `/tapahtumat?alkaen=2024-04-01T00:00:00&paattyen=2024-06-30T23:59:59`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Ehto**: Autentikointi onnistuu

**Vastauskoodi**: `200 OK`

**Sisältöesimerkkejä**:

```json
[
  {
    "tapahtuma_id": 2,
    "tapahtuman_nimi": "Kekkosen synttärit",
    "paikka": "Vaasa",
    "katuosoite": "Vaasankatu 1",
    "alku": "2024-06-12T17:00:00",
    "loppu": "2024-06-12T23:59:00",
    "lippu_lukum": 667,
    "tapahtuman_lipputyypit": [
      {
        "id": 2,
        "hinta": 10.0,
        "tapahtuma": 2,
        "lipputyyppi": 1
      }
    ]
  },
  {
    "tapahtuma_id": 3,
    "tapahtuman_nimi": "Cheek - Paluu areenalle",
    "paikka": "Olympiastadion - Helsinki",
    "katuosoite": "Paavo Nurmen tie 1",
    "alku": "2031-12-22T12:30:00",
    "loppu": "2031-12-22T14:15:00",
    "lippu_lukum": 9999,
    "tapahtuman_lipputyypit": [
      {
        "id": 3,
        "hinta": 7.0,
        "tapahtuma": 3,
        "lipputyyppi": 2
      },
      {
        "id": 4,
        "hinta": 10.0,
        "tapahtuma": 3,
        "lipputyyppi": 1
      }
    ]
  }
]
```

## Epäonnistuneen pyynnön palautus

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
