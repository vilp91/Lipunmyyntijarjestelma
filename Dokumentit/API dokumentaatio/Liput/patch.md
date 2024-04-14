# Päivitä yksittäinen lippu käytetyksi

Päivittää yksittäisen lipun käytetty-attribuutin, kun käyttäjällä on vaadittavat oikeudet.

__URL__: `/liput/{id}`

__METODI__: `PATCH`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Admin, Myyjä tai Lipuntarkastaja

Anna tiedot:

```json
{
  "kaytetty": "[YYYY-MM-DDTHH:mm:ss]"
}
```

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `200 OK`

__Esimerkkejä päivitetystä tietueesta__:

```Json
{
    "lippunumero": "39135be8-0cbb-48ac-857f-1840bfdef7d8",
    "tapahtumanLipputyyppi": {
        "tapahtumanLipputyyppiId": 1,
        "hinta": 10.0,
        "tapahtuma": {
            "tapahtumanNimi": "Sukankudontakilpailu",
            "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
            "katuosoite": "Kuninkaantammentie 19",
            "alku": "2024-06-06T14:00:00",
            "loppu": "2024-06-06T16:00:00",
            "lippuLukum": 10,
            "myydytLiputLukum": 0,
            "tapahtuma_id": 1
        },
        "lipputyyppi": {
            "lipputyyppiId": 1,
            "tyyppi": "perus"
        }
    },
    "myyntitapahtuma": {
        "myyntitapahtumaId": 1,
        "kayttaja": {
            "kayttajaId": 1,
            "rooli": {
                "rooliId": 1,
                "rooli": "ROLE_MYYJA"
            },
            "etunimi": "Teppo",
            "sukunimi": "Testaaja",
            "puhnro": null,
            "katuosoite": null,
            "salasana": "$2a$10$SL3.JZHWibv3060I/XA/buE12wkXEmZ5auf32AW9fXPxWGyeIQzQe",
            "kayttajanimi": "teppo"
        },
        "aikaleima": "2024-04-14T18:30:47.758188"
    },
    "hinta": 10.0,
    "kaytetty": "2024-04-14T18:00:00",
    "lippu_id": 1
}
```

## Epäonnistuneen pyynnön palautus

__Ehto__: {id} arvoa ei löydy tietokannasta.

__Vastauskoodi__: `404 NOT FOUND`

__Esimerkkisisältö__:

```json
{
     "message": "Tarkista lippuId",
}
```

TAI

__Ehto__: Lippu on jo kaytetty

__Vastauskoodi__: `400 BAD REQUEST`

__Esimerkkisisältö__:

```json
{
    "message": "Lippu on jo käytetty"
}
```

TAI

__Ehto__: Autentikointi epäonnistuu

__Koodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Koodi__: `403 FORBIDDEN`
