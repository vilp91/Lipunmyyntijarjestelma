# Luodaan uusi käyttäjä

Luo uuden käyttäjän, kun käyttäjällä on vaadittavat oikeudet

**URL**: `/kayttajat`

**Metodi**: `POST`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Admin

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
            "rooliId": "[int]",
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

```json
{
    "message": "RooliId puuttuu",
}
```
---
```json
{
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
}
```
```json
{
    "message": "Validation failed for object='kayttaja'. Error count: 1",
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

```json
{
    "message": "Poista pyynnöstä kayttajaId",
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

```json
{
    "message": "Roolia id:llä 7 ei löydy.",
}
```

TAI

**Ehto**: Käyttäjä annetulla käyttäjanimellä on jo olemassa.

**Vastauskoodi**: `400 BAD REQUEST`

**Sisältöesimerkki**:

```json
{
    "message": "Käyttäjä käyttäjänimellä lauri on jo olemassa.",
}
```

TAI

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Vastauskoodi__: `403 FORBIDDEN`

