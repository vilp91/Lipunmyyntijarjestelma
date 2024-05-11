# Luo kaikki yksittäisen tapahtuman loput liput

Luo tapahtumalle kaikki myymättömät liput, kun käyttäjällä on vaadittavat oikeudet.

__URL__: `/tapahtumat/{id}/liput`

__Vapaaehtoiset parametrit__: "lipputyyppiId" - määritetään tulostettavien lippujen lipputyyppi. Jos arvoa ei anneta, luodaan liput oletusarvoisesti lipputyypin nimellä "perus".

esim. `/tapahtumat/1/liput?lipputyyppiId=2`

__Metodi__: `POST`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Admin tai myyjä

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `201 CREATED`

__Sisältöesimerkkejä__:

```json
[
    {
        "lippunumero": "71f8a7d7-54cc-4ce4-a715-2260af2f15e0",
        "tapahtumanLipputyyppi": {
            "tapahtumanLipputyyppiId": 1,
            "hinta": 15.0,
            "tapahtuma": {
                "tapahtumaId": 1,
                "tapahtumanNimi": "Sukankudontakilpailu",
                "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
                "katuosoite": "Kuninkaantammentie 19",
                "alku": "2024-06-06T14:00:00",
                "loppu": "2024-06-06T16:00:00",
                "lippuLukum": 10,
                "myydytLiputLukum": 10,
                "poistettu": false
            },
            "lipputyyppi": {
                "lipputyyppiId": 1,
                "tyyppi": "perus",
                "poistettu": false
            },
            "poistettu": false
        },
        "myyntitapahtuma": null,
        "hinta": 15.0,
        "kaytetty": null,
        "poistettu": false,
        "lippu_id": 4
    },
    {
        "lippunumero": "fc96bfd0-66c7-48e4-95a5-bfd5004cb949",
        "tapahtumanLipputyyppi": {
            "tapahtumanLipputyyppiId": 1,
            "hinta": 15.0,
            "tapahtuma": {
                "tapahtumaId": 1,
                "tapahtumanNimi": "Sukankudontakilpailu",
                "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
                "katuosoite": "Kuninkaantammentie 19",
                "alku": "2024-06-06T14:00:00",
                "loppu": "2024-06-06T16:00:00",
                "lippuLukum": 10,
                "myydytLiputLukum": 10,
                "poistettu": false
            },
            "lipputyyppi": {
                "lipputyyppiId": 1,
                "tyyppi": "perus",
                "poistettu": false
            },
            "poistettu": false
        },
        "myyntitapahtuma": null,
        "hinta": 15.0,
        "kaytetty": null,
        "poistettu": false,
        "lippu_id": 5
    }
]
```
## Epäonnistuneen pyynnön palautus


__Ehto__: Tapahtumaa ei ole olemassa

__Vastauskoodi__: `404 NOT FOUND`

__Esimerkkisisältö__:

```json
{
...
   "message": "Tapahtumaa annetulla id:llä: 7 ei löydy",
...
}
```

TAI

__Ehto__: Tapahtumaan ei ole yhtään vapaata lippua jäljellä

__Vastauskoodi__: `400 BAD REQUEST`

__Esimerkkisisältö__:

```json
{
...
    "message": "Ei lisättäviä lippuja, kaikki liput on jo luotu",
...
}
```

TAI

__Ehto__: Annetulla lipputyyppiId:llä ei löytynyt lipputyyppiä

__Vastauskoodi__: `400 BAD REQUEST`

__Esimerkkisisältö__:

```json
{
...
    "message": "Ei lipputyyppiä annetulla lipputyyppiId:llä 66",
...
}
```

TAI

__Ehto__: Tapahtumalla ei ole lipputyyppiä 'perus'

__Vastauskoodi__: `400 BAD REQUEST`

__Esimerkkisisältö__:

```json
{
...
    "message": "Tapahtumalle ei löytynyt oletuslipputyyppiä 'perus'",
...
}
```

TAI

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Vastauskoodi__: `403 FORBIDDEN`