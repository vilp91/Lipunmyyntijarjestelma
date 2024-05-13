# Päivitä yksittäinen lipputyyppi

Päivittää yksittäisen lipputyypin tietoineen, kun käyttäjällä on vaadittavat oikeudet.

**URL**: `/lipputyypit/{id}`

**Metodi**: `PUT`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

Anna päivitettävän lipputyypin tiedot:

```json
{
  "tyyppi": "[string]"
}
```

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Esimerkkejä päivitetyistä tietueista**:

```Json
{
  "lipputyyppi_id": 1,
  "tyyppi": "perus"
}
```

```json
{
  "lipputyyppi_id": 2,
  "tyyppi": "lapsi"
}
```

## Epäonnistuneen pyynnön palautus

**Ehto**: {id} arvoa ei löydy tietokannasta.

**Vastauskoodi**: `404 NOT FOUND`

**Esimerkkisisältö**:

```json
{
  "timestamp": "2024-05-13T11:37:58.301+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Lipputyyppiä id:llä 32 ei löydy",
  "path": "/lipputyypit/32"
}
```

TAI

**Ehto**: Pakollinen tieto puuttuu

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "timestamp": "2024-05-13T11:39:02.159+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed for object='lipputyyppi'. Error count: 1",
  "path": "/lipputyypit/29"
}
```

TAI

**Ehto**: lipputyyppi oli jo tietokannassa. Ei voida luoda kaksoikappaletta.

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "timestamp": "2024-05-13T11:39:35.187+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Lipputyyppi 'perus' löytyy jo tietokannasta.",
  "path": "/lipputyypit/29"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
