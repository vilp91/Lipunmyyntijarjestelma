# Hae lipputyypit

Hakee ja näyttää kaikki tietokannassa olevat lipputyypit tietoineen.

**URL**: `/lipputyypit`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkkejä**:

Haetaan tallennetut lipputyypit.

```json
[
  {
    "lipputyyppiId": 29,
    "tyyppi": "perus"
  },
  {
    "lipputyyppiId": 30,
    "tyyppi": "lapsi"
  },
  {
    "lipputyyppiId": 33,
    "tyyppi": "VIP"
  },
  {
    "lipputyyppiId": 35,
    "tyyppi": "opiskelija"
  },
  {
    "lipputyyppiId": 36,
    "tyyppi": "eläkeläinen"
  }
]
```

TAI

Tallennettuja lipputyyppejä ei ole.

```json
[]
```

## Epäonnistuneen pyynnön palautus

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
