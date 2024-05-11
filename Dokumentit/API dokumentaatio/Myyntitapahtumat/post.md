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
    "aika": "2024-05-11T22:57:30.5813965",
    "kayttajaId": 2,
    "liput": [
        {
            "id": 9,
            "lippunumero": "27b39120-fe75-4bf3-9531-6c02bc672035",
            "tyyppi": "perus",
            "tapahtuma": "Sukankudontakilpailu",
            "hinta": 15.0
        },
        {
            "id": 10,
            "lippunumero": "fe5bb795-f802-4bb6-8910-6e479acd35db",
            "tyyppi": "perus",
            "tapahtuma": "Sukankudontakilpailu",
            "hinta": 15.0
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
