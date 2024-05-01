# Luo uusi myyntitapahtuma

Luo uuden myyntitapahtuman.

**URL**: `/myyntitapahtumat`

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

Anna luotavan tapahtuman tiedot:

```json
[
  {
    "tapahtumanLipputyyppi": "[long]",
    "maara": "[int]"
  }
]
```

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `201 CREATED`

**Sisältöesimerkkejä**:

```json
{
  "id": 4,
  "summa": 30.0,
  "aika": "2024-05-01T22:15:48.9194723",
  "liput": [
      {
          "id": 6,
          "lippunumero": "9280cb32-eaac-49da-9b18-587856d67524",
          "tyyppi": "perus",
          "tapahtuma": "Sukankudontakilpailu",
          "hinta": 15.0
      },
      {
          "id": 7,
          "lippunumero": "cd7fe95e-6b42-4a8e-8f71-44aa37f07034",
          "tyyppi": "perus",
          "tapahtuma": "Sukankudontakilpailu",
          "hinta": 15.0
      }
  ],
  "kayttaja": {
      "kayttajaId": 2,
      "etunimi": "Heikki",
      "sukunimi": "Hallinnoija",
      "puhnro": null,
      "katuosoite": null
  }
}
```

## Epäonnistunut tapahtuma

**Ehto**: Virheellinen tapahtumanLipputyyppi/tapahtumanLipputyyppiä ei löydy tietokannasta (esim. negatiivinen numero).

**Vastauskoodi**: `400 BAD REQUEST`

**Sisältöesimerkkejä**:

```json
[
  {
    "tapahtumanLipputyyppi": 999,
    "maara": 2
  }
]
```

```json
{
...
    "message": "Tapahtuman lipputyypin valinnassa virhe. Tarkista onko lipputyyppiä valitulla id:llä olemassa GET /tapahtumanlipputyypit - Myyntitapahtuma on peruttu.",
...
}
```

---

**Ehto**: Virheellinen arvo/tietotyyppi kentässä.

**Vastauskoodi**: `400 BAD REQUEST`

**Sisältöesimerkkejä**:

```json
[
  {
    "tapahtumanLipputyyppi": 1,
    "maara": "unlimited power"
  }
]
```

```json
{
...
    "message": "JSON parse error: Cannot deserialize value of type `int`  from String \"unlimited power\": not a valid `int` value",
...
}
```

TAI

**Ehto**: Pyydettyä lippua ei ole saatavilla

**Vastauskoodi**: `400 BAD REQUEST`

```json
[
  {
    "tapahtumanLipputyyppi": 1,
    "maara": 9999
  }
]
```

```json
{
  "message": "Yksi tai useampi lippu ei ollut saatavilla. Myyntitapahtuma on peruttu.",
}
```

TAI

**Ehto**: Pyynnössä ei ole yhdenkään lipun tietoja

**Vastauskoodi**: `400 BAD REQUEST`

```json
    {
      "message": "Myyntitapahtuma ei sisällä lippuja. Myyntitapahtuma on peruttu"
    }
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
