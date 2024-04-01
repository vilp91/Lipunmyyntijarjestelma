# Luo uusi myyntitapahtuma

Luo uuden myyntitapahtuman ilman käyttäjää (käyttäjän liittäminen myyntitapahtumaan päivitetään apiin myöhemmin).

**URL**: `/myyntitapahtumat`

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Ei mitään

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
  "summa": 20.0,
  "aika": "2024-03-04T18:43:59.2011012",
  "liput": [
    {
      "id": 6,
      "tyyppi": "perus",
      "tapahtuma": "Sukankudontakilpailu",
      "hinta": 10.0
    },
    {
      "id": 7,
      "tyyppi": "perus",
      "tapahtuma": "Sukankudontakilpailu",
      "hinta": 10.0
    }
  ]
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
    "message": "Tapahtuman lipputyypin valinnassa virhe. Tarkista onko Tapahtuman lipputyyppiä syöttämällä ID:lläsi olemassa (GET /tapahtumanlipputyypit).",
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
Yksi tai useampi lippu ei ollut saatavilla. Myyntitapahtuma on peruttu.
```

TAI

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`
