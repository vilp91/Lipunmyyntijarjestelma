# Luodaan uusi rooli

Luo uuden roolin, kun käyttäjällä on vaadittavat oikeudet

**URL**: `/roolit`

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

Anna luotavan roolin tiedot

```json
{
  "rooli": "[String]"
}
```

Lisävaatimukset:

rooli kentän muotoilu: "^ROLE\_[A-Z]+$"

## Onnistuneen pyynnön palautus

**Ehto**: Uusi rooli luotiin onnistuneesti.

**Vastauskoodi**: `201 CREATED`

**Esimerkkisisältö**: Uusi rooli luotu

```json
{
  "rooliId": 3,
  "rooli": "ROLE_LIPUNTARKASTAJA"
}
```

## Epäonnistuneen pyynnön palautus

**Ehto**: Vaadittu tieto puuttuu

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "roobi": "ROLE_LIPUNTARKASTAJA"
}
```

```json
{
  "timestamp": "2024-05-13T13:39:35.340+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed for object='rooli'. Error count: 1",
  "path": "/roolit"
}
```

TAI

**Ehto**: Pyynnössä on tapahtuma_id.

**Vastauskoodi**: `400 BAD REQUEST`

**Sisältöesimerkki**:

```json
{
  "rooliId": 3,
  "rooli": "ROLE_LIPUNTARKASTAJA"
}
```

```json
{
  "timestamp": "2024-05-13T13:39:07.628+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Poista pyynnöstä rooliId",
  "path": "/roolit"
}
```

TAI

**Ehto**: Pyynnössä ei noudateta ohjeistettua muotoilua.

**Vastauskoodi**: `400 BAD REQUEST`

**Sisältöesimerkki**:

```json
{
  "rooli": "LIPUNTARKASTAJA"
}
```

```json
{
  "timestamp": "2024-05-13T13:36:56.957+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Roolin kirjoitusasu on väärä. Roolin tulee alkaa 'ROLE_', jonka jälkeen käytetään isoja kirjaimia.",
  "path": "/roolit"
}
```

TAI

**Ehto**: Rooli annetulla nimellä on jo olemassa.

**Vastauskoodi**: `400 BAD REQUEST`

**Sisältöesimerkki**:

```json
{
  "rooli": "ROLE_LIPUNTARKASTAJA"
}
```

```json
{
  "timestamp": "2024-05-13T13:38:11.117+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Rooli nimellä 'ROLE_LIPUNTARKASTAJA' on jo olemassa.",
  "path": "/roolit"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
