# Luodaan uusi tapahtuma

Luo uuden tapahtuman, kun käyttäjällä on vaadittavat oikeudet.

**URL**: `/tapahtumat`

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

Anna luotavan tapahtuman tiedot

```json
{
  "tapahtumanNimi": "[string]",
  "paikka": "[string]",
  "katuosoite": "[string]",
  "alku": "[YYYY-MM-DDTHH:mm:ss]",
  "loppu": "[YYYY-MM-DDTHH:mm:ss]",
  "lippu_lukum": "[int]"
}
```

## Onnistuneen pyynnön palautus

**Ehto**: Uusi tapahtuma luotiin onnistuneesti.

**Vastauskoodi**: `201 CREATED`

**Esimerkkisisältö**: Uusi tapahtuma luotu

```json
{
  "tapahtumaId": 6,
  "tapahtumanNimi": "Karin karaokeiltama",
  "paikka": "Lepakkomies",
  "katuosoite": "Helsinginkatu 1, 00500 Helsinki",
  "alku": "2024-04-06T19:00:00",
  "loppu": "2024-04-06T23:30:00",
  "lippuLukum": 50,
  "myydytLiputLukum": 0
}
```

## Epäonnistuneen pyynnön palautus

**Ehto**: Syntaksi virhe. Esimerkiksi kirjaimia numero kentällä.

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**: Uutta tapahtumaa ei luotu, koska jossain kentässä on siihen kuulumattomia merkkejä.

```json
{
  "tapahtumanNimi": "Karin karaokeiltama",
  "paikka": "Lepakkomies",
  "katuosoite": "Helsinginkatu 1, 00500 Helsinki",
  "alku": "2024-04-06T19:00:00",
  "loppu": "2024-04-06T23:30:00",
  "lippu_lukum": "Tarpeeksi"
}
```

```json
{
  "timestamp": "2024-05-13T10:53:43.839+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "JSON parse error: Cannot deserialize value of type `int` from String \"Tarpeeksi\": not a valid `int` value",
  "path": "/tapahtumat"
}
```

TAI

**Ehto**: Vaadittu tieto puuttuu

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "tapahtumanNimi": "Karin karaokeiltama",
  "paikka": "Lepakkomies",
  "katuosoite": "",
  "alku": "2024-04-06T19:00:00",
  "loppu": "2024-04-06T23:30:00",
  "lippu_lukum": "50"
}
```

```json
{
  "timestamp": "2024-05-13T10:54:27.314+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed for object='tapahtuma'. Error count: 1",
  "path": "/tapahtumat"
}
```

TAI

**Ehto**: Pyynnössä on tapahtuma_id.

**Vastauskoodi**: `400 BAD REQUEST`

**Sisältöesimerkki**:

```json
{
  "tapahtuma_id": 5,
  "tapahtumanNimi": "Karin karaokeiltama",
  "paikka": "Lepakkomies",
  "katuosoite": "Helsinginkatu 1, 00500 Helsinki",
  "alku": "2024-04-06T19:00:00",
  "loppu": "2024-04-06T23:30:00",
  "lippu_lukum": "50"
}
```

```json
{
  "timestamp": "2024-05-13T10:56:33.413+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Poista pyynnöstä tapahtuma_id",
  "path": "/tapahtumat"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
