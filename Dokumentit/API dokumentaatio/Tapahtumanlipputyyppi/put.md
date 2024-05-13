# Päivitä yksittäinen tapahtumanlipputyyppi

Päivittää yksittäisen tapahtumanlipputyypin tietoineen, kun käyttäjällä on vaadittavat oikeudet.

**URL**: `/tapahtumanlipputyypit/{id}`

**Metodi**: `PUT`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

Anna päivitettävän lipputyypin tiedot:

```json
{
  "hinta": "[float]",
  "tapahtuma": "[Long]",
  "lipputyyppiId": "[Long]"
}
```

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Esimerkkejä päivitetyistä tietueista**:

```Json
{
    "id": 1,
    "hinta": 10.0,
    "tapahtuma": 1,
    "lipputyyppiId": 1,
    "lipputyyppi": "perus"
}
```

## Epäonnistuneen pyynnön palautus

**Ehto**: {id} arvoa ei löydy tietokannasta.

**Vastauskoodi**: `404 NOT FOUND`

**Esimerkkisisältö**:

```Json
{
    "timestamp": "2024-05-13T12:35:29.445+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Tapahtumanlipputyyppiä id:llä '22' ei löydy.",
    "path": "/tapahtumanlipputyypit/22"
}
```

TAI

**Ehto**: Pakollinen tieto puuttuu

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "hinta": 24.95,
  "lipputyyppiId": 29
}
```

```json
{
  "timestamp": "2024-05-13T12:36:55.492+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed for object='tapahtumanlipputyyppiDTO'. Error count: 1",
  "path": "/tapahtumanlipputyypit/22"
}
```

---

**Esimerkkisisältö**:

```json
{
  "hinta": 24.95,
  "tapahtuma": 57
}
```

```json
{
  "timestamp": "2024-05-13T12:37:54.125+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed for object='tapahtumanlipputyyppiDTO'. Error count: 1",
  "path": "/tapahtumanlipputyypit/22"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Koodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Koodi**: `403 FORBIDDEN`
