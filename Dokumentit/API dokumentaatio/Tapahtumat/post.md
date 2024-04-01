# Luodaan uusi tapahtuma

Luo uuden tapahtuman, kun käyttäjällä on vaadittavat oikeudet

**URL**: `/tapahtumat`

**Metodi**: `POST`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Admin

Anna luotavan tapahtuman tiedot

```json
{
  "tapahtuman_nimi": "[string]",
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
    "tapahtuma_id": 6,
    "tapahtuman_nimi": "Karin karaokeiltama",
    "paikka": "Lepakkomies",
    "katuosoite": "Helsinginkatu 1, 00500 Helsinki",
    "alku": "2024-04-06T19:00:00",
    "loppu": "2024-04-06T23:30:00",
    "lippu_lukum": 50,
    "myydyt_liput_lukum": 0
}
```

## Epäonnistuneen pyynnön palautus

**Ehto**: Syntaksi virhe. Esimerkiksi kirjaimia numero kentällä.

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**: Uutta tapahtumaa ei luotu, koska jossain kentässä on siihen kuulumattomia merkkejä.

```json
{
  "tapahtuman_nimi": "Karin karaokeiltama",
  "paikka": "Lepakkomies",
  "katuosoite": "Helsinginkatu 1, 00500 Helsinki",
  "alku": "2024-04-06T19:00:00",
  "loppu": "2024-04-06T23:30:00",
  "lippu_lukum": "Tarpeeksi"
}
```

```json
{
...
    "message": "JSON parse error: Cannot deserialize value of type `int` from String \"Tarpeeksi\": not a valid `int` value",
...
}
```

TAI

**Ehto**: Vaadittu tieto puuttuu

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "tapahtuman_nimi": "Karin karaokeiltama",
  "paikka": "Lepakkomies",
  "katuosoite": "",
  "alku": "2024-04-06T19:00:00",
  "loppu": "2024-04-06T23:30:00",
  "lippu_lukum": "50"
}
```

```json
{
...
    "defaultMessage": "Paikka ja katuosoite ovat pakollisia tietoja"
...
}
```

TAI

**Ehto**: Pyynnössä on tapahtuma_id.

**Vastauskoodi**: `400 BAD REQUEST`

**Sisältöesimerkki**:

```json
{
  "tapahtuma_id": 5,
  "tapahtuman_nimi": "Karin karaokeiltama",
  "paikka": "Lepakkomies",
  "katuosoite": "Helsinginkatu 1, 00500 Helsinki",
  "alku": "2024-04-06T19:00:00",
  "loppu": "2024-04-06T23:30:00",
  "lippu_lukum": "50"
}
```

```json
{
...
    "message": "Poista pyynnöstä tapahtuma_id",
...
}

```

TAI

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Vastauskoodi__: `403 FORBIDDEN`

