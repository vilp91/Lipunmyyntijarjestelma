# Päivitä yksittäinen tapahtumanlipputyyppi

Päivittää yksittäisen tapahtumanlipputyypin tietoineen, kun käyttäjällä on vaadittavat oikeudet.

__URL__: `/tapahtumanlipputyypit/{id}`

__METODI__: `PUT`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Admin

Anna päivitettävän lipputyypin tiedot:

```json
{
  "hinta": "[float]",
  "tapahtuma": "[Long]",
  "lipputyyppiId": "[Long]"
}
```

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `200 OK`

__Esimerkkejä päivitetyistä tietueista__:

```Json
{
    "id": 1,
    "hinta": 10.0,
    "tapahtuma": 1,
    "lipputyyppiId": 1,
    "lipputyyppi": "perus"
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
    "hinta": "69",
    "lipputyyppiId": "1"
}
```

```json
{
...
    "defaultMessage": "Valitse tapahtuma"
...
}
```
---
__Esimerkkisisältö__:

```json
{
    "hinta": "69",
    "tapahtuma": "1"
}
```

```json
{
...
    "defaultMessage": "Lipputyyppi Id on pakollinen"
...
}
```

TAI

__Ehto__: Autentikointi epäonnistuu

__Koodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Koodi__: `403 FORBIDDEN`