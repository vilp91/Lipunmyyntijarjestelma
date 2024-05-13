# Päivitä käyttäjä

Päivittää käyttäjän roolin, nimet, puhelinnumeron ja osoitteen, kun käyttäjällä on vaadittavat oikeudet.

**URL**: `/kayttajat/{id}`

**Metodi**: `PUT`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

Anna päivitettävän lipputyypin tiedot:

```json
{
  "rooli": {
    "rooliId": "[int]"
  },
  "etunimi": "[String]",
  "sukunimi": "[String]",
  "puhnro": "[String]",
  "katuosoite": "[String]"
}
```

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Esimerkkejä päivitetyistä tietueista**:

```Json
{
    "kayttajaId": 1,
    "rooli": {
        "rooliId": 2,
        "rooli": "ROLE_ADMIN"
    },
    "etunimi": "Minna",
    "sukunimi": "Mallikas",
    "puhnro": "0123456789",
    "katuosoite": "Mallikatu 2",
    "salasana": "$2a$10$EmykihVxIaZzT18YsVbwAOWI/suh.BuRx5ZS5n1KCa5cxb0Qy8DF.",
    "kayttajanimi": "teppo"
}
```

## Epäonnistuneen pyynnön palautus

**Ehto**: {id} arvoa ei löydy tietokannasta.

**Vastauskoodi**: `404 NOT FOUND`

TAI

**Ehto**: Pakollinen tieto puuttuu

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "message": "Tarkista etu- ja sukunimi"
}
```

TAI

**Ehto**: Annettu rooli id ei ole olemassa

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "timestamp": "2024-05-13T13:26:30.327+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Tarkista rooliId",
  "path": "/kayttajat/36"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
