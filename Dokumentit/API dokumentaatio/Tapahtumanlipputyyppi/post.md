# Luo uuden tapahtumanlipputyypin

Luo uusi tapahtumanlipputyyppi.

**URL**: `/tapahtumanlipputyypit`

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

**Esimerkkisisältö**:

```json
{
  "hinta": "[float]",
  "tapahtuma": "[Long]",
  "lipputyyppiId": "[Long]"
}
```

## Onnistuneen pyynnön palautus

**Ehto**: Pyynnössä on valmiiksi olemassa olevat tapahtuma ja lipputyyppi sekä hinta on positiivinen luku.

**Vastauskoodi**: `201 CREATED`

**Esimerkkisisältö**:

```json
{
  "id": 1,
  "hinta": 10.0,
  "tapahtuma": 1,
  "lipputyyppiId": 1,
  "lipputyyppi": "perus"
}
```

## Epäonnistuneen pyynnön palautus

**Ehto**: Pakollinen tieto on virheellinen

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "hinta": -1,
  "tapahtuma": 1,
  "lipputyyppiId": 1
}
```

```json
{
  "timestamp": "2024-05-13T12:25:42.131+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed for object='tapahtumanlipputyyppiDTO'. Error count: 1",
  "path": "/tapahtumanlipputyypit"
}
```

---

**Esimerkkisisältö**:

```json
{
  "hinta": 25.0,
  "tapahtuma": 999,
  "lipputyyppiId": 1
}
```

```json
{
  "timestamp": "2024-05-13T12:20:25.644+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Tapahtumaa id:llä '999' ei löydy.",
  "path": "/tapahtumanlipputyypit"
}
```

---

**Esimerkkisisältö**:

```json
{
  "hinta": 25.0,
  "tapahtuma": 1,
  "lipputyyppiId": 999
}
```

```json
{
  "timestamp": "2024-05-13T12:21:35.647+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Lipputyyppiä id:llä '999' ei löydy",
  "path": "/tapahtumanlipputyypit"
}
```

TAI

**Ehto**: Annetulla lipputyyppiId:llä on jo tapahtumanlipputyyppi.

**Vastauskood**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "hinta": "5",
  "tapahtuma": "1",
  "lipputyyppiId": "2"
}
```

```json
{
  "timestamp": "2024-05-13T12:22:19.082+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "LipputyyppiId:llä '2' on jo olemassa tapahtumanlipputyyppi",
  "path": "/tapahtumanlipputyypit"
}
```

**Ehto**: Autentikointi epäonnistuu

**Koodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Koodi**: `403 FORBIDDEN`
