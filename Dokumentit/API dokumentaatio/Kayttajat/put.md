# Päivitä käyttäjä

Päivittää käyttäjän roolin, nimet, puhelinnumeron ja osoitteen, kun käyttäjällä on vaadittavat oikeudet.

__URL__: `/kayttajat/{id}`

__METODI__: `PUT`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Admin

Anna päivitettävän lipputyypin tiedot:

```json
{
    "rooli": {
        "rooliId": "[int]",
    },
    "etunimi": "[String]",
    "sukunimi": "[String]",
    "puhnro": "[String]",
    "katuosoite": "[String]",
}
```

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `200 OK`

__Esimerkkejä päivitetyistä tietueista__:

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

__Ehto__: {id} arvoa ei löydy tietokannasta.

__Vastauskoodi__: `404 NOT FOUND`

TAI

__Ehto__: Pakollinen tieto puuttuu

__Vastauskoodi__: `400 BAD REQUEST`

__Esimerkkisisältö__:

```json
{
    "message": "Tarkista etu- ja sukunimi"
}
```

TAI

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Vastauskoodi__: `403 FORBIDDEN`
