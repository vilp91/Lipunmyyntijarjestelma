# Luo uuden lipputyypin

Luo tapahtumalle uuden lipputyypin, kun käyttäjällä on vaadittavat oikeudet.

**URL**: `/lipputyypit`

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

Anna luotavan lipputyypin tiedot:

```json
{
  "tyyppi": "[string]"
}
```

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `201 CREATED`

**Sisältöesimerkkejä**:

```json
{
  "lipputyyppi_id": 4,
  "tyyppi": "opiskelija"
}
```

## Epäonnistuneen pyynnön palautus

**Ehto**: Pakollinen tieto puuttuu

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "timestamp": "2024-05-13T11:33:56.440+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed for object='lipputyyppi'. Error count: 1",
  "path": "/lipputyypit"
}
```

TAI

**Ehto**: lipputyyppi oli jo tietokannassa. Ei voida luoda kaksoikappaletta.

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "timestamp": "2024-05-13T11:32:17.511+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Lipputyyppi 'perus' löytyy jo tietokannasta.",
  "path": "/lipputyypit"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
