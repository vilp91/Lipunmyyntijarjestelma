# Luodaan uusi käyttäjä

Luo uuden käyttäjän, kun käyttäjällä on vaadittavat oikeudet

**URL**: `/kayttajat`

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

Anna luotavan käyttäjän tiedot

```json
{
  "rooli": {
    "rooliId": "[int]",
    "rooli": "[String]"
  },
  "etunimi": "[String]",
  "sukunimi": "[String]",
  "puhnro": "[String]",
  "katuosoite": "[String]",
  "salasana": "[String]",
  "kayttajanimi": "[String]"
}
```

TAI

```json
{
  "rooli": {
    "rooliId": "[int]"
  },
  "etunimi": "[String]",
  "sukunimi": "[String]",
  "puhnro": "[String]",
  "katuosoite": "[String]",
  "salasana": "[String]",
  "kayttajanimi": "[String]"
}
```

## Onnistuneen pyynnön palautus

**Ehto**: Uusi käyttäjä luotiin onnistuneesti.

**Vastauskoodi**: `201 CREATED`

**Esimerkkisisältö**: Uusi käyttäjä luotu

```json
{
  "kayttajaId": 3,
  "rooli": {
    "rooliId": 3,
    "rooli": "ROLE_LIPUNTARKASTAJA"
  },
  "etunimi": "Lauri",
  "sukunimi": "Lipuntarkastaja",
  "puhnro": "0700123123",
  "katuosoite": null,
  "salasana": null,
  "kayttajanimi": "lauri"
}
```

## Epäonnistuneen pyynnön palautus

**Ehto**: Vaadittu tieto puuttuu

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "etunimi": "Lauri",
  "sukunimi": "Lipuntarkastaja",
  "puhnro": "0700123123",
  "katuosoite": null,
  "salasana": "lippulappu",
  "kayttajanimi": "lauri"
}
```

Vastaus:

```json
{
  "timestamp": "2024-05-13T13:13:26.382+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "RooliId puuttuu",
  "path": "/kayttajat"
}
```

---

```json
{
  "rooli": {
    "rooliId": 3,
    "rooli": "ROLE_LIPUNTARKASTAJA"
  },
  "etunimi": "Lauri",
  "sukunimi": "Lipunmyyjä",
  "puhnro": "0700123123",
  "katuosoite": null,
  "kayttajanimi": "lauri"
}
```

Vastaus:

```json
{
  "timestamp": "2024-05-13T13:14:02.890+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed for object='kayttaja'. Error count: 1",
  "path": "/kayttajat"
}
```

TAI

**Ehto**: Pyynnössä on kayttajaId.

**Vastauskoodi**: `400 BAD REQUEST`

**Sisältöesimerkki**:

```json
{
  "kayttajaId": 3,
  "rooli": {
    "rooliId": 3,
    "rooli": "ROLE_LIPUNTARKASTAJA"
  },
  "etunimi": "Lauri",
  "sukunimi": "Lipunmyyjä",
  "puhnro": "0700123123",
  "katuosoite": null,
  "salasana": "lippulappu",
  "kayttajanimi": "lauri"
}
```

Vastaus:

```json
{
  "timestamp": "2024-05-13T13:12:08.387+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Poista pyynnöstä kayttajaId",
  "path": "/kayttajat"
}
```

TAI

**Ehto**: Annetulla rooliId:llä ei ole olemassa roolia.

**Vastauskoodi**: `400 BAD REQUEST`

**Sisältöesimerkki**:

```json
{
  "rooli": {
    "rooliId": 7
  },
  "etunimi": "Lauri",
  "sukunimi": "Lipunmyyjä",
  "puhnro": "0700123123",
  "katuosoite": null,
  "salasana": "lippulappu",
  "kayttajanimi": "lauri"
}
```

Vastaus:

```json
{
  "timestamp": "2024-05-13T12:55:45.737+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Roolia id:llä 7 ei löydy.",
  "path": "/kayttajat"
}
```

TAI

**Ehto**: Käyttäjä annetulla käyttäjanimellä on jo olemassa.

**Vastauskoodi**: `400 BAD REQUEST`

**Sisältöesimerkki**:

```json
{
  "message": "Käyttäjä käyttäjänimellä lauri on jo olemassa."
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
