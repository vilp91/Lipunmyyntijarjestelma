# Päivitä yksittäinen lippu käytetyksi

Päivittää yksittäisen lipun käytetty-attribuutin, kun käyttäjällä on vaadittavat oikeudet.

**URL**: `/liput/{id}`

**Metodi**: `PATCH`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin, Myyjä tai Lipuntarkastaja

Anna tiedot:

```json
{
  "kaytetty": "[YYYY-MM-DDTHH:mm:ss]"
}
```

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Esimerkkejä päivitetystä tietueesta**:

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

**Ehto**: {id} arvoa ei löydy tietokannasta.

**Vastauskoodi**: `404 NOT FOUND`

**Esimerkkisisältö**:

```json
{
  "timestamp": "2024-05-13T12:13:57.717+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Tarkista lippuId",
  "path": "/liput/300"
}
```

TAI

**Ehto**: Lippu on jo kaytetty

**Vastauskoodi**: `400 BAD REQUEST`

**Esimerkkisisältö**:

```json
{
  "timestamp": "2024-05-13T12:13:31.155+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Lippu on jo käytetty",
  "path": "/liput/274"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Koodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Koodi**: `403 FORBIDDEN`
