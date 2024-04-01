# Hae tulevat tapahtumat

Hakee kaikki tietokannassa olevat tapahtumat, joille on asetettu alkupäivä, joka on kuluvan päivän jälkeen.

__URL__: `/tapahtumat/tulevat`

__Metodi__: `GET`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Ei mitään

## Onnistuneen pyynnön palautus

__Ehto__: Kuluvan päivän jälkeisiä tapahtumia ei ole tai tapahtumille ei ole asetettu alkupäivää. Käyttäjälle ei näytetä tuloksia.

__Vastauskoodi__: `200 OK`

__Sisältö__: `{[]}`

TAI

__Ehto__: Käyttäjälle näytetään tulokset.

__Vastauskoodi__: `200 OK`

__Esimerkkisisältö__, 23.2.2024 tehtynä hakuna käyttäjälle näytetään kaksi ensimmäistä Tapahtumaa:
```json
[
    {
        "tapahtuma_id": 2,
        "tapahtuman_nimi": "Kekkosen synttärit",
        "paikka": "Vaasa",
        "katuosoite": "Vaasankatu 1",
        "alku": "2024-03-12T17:00:00",
        "loppu": "2024-03-12T23:59:00",
        "lippu_lukum": 667
    },
    {
        "tapahtuma_id": 3,
        "tapahtuman_nimi": "Cheek - Paluu areenalle",
        "paikka": "Olympiastadion - Helsinki",
        "katuosoite": "Paavo Nurmen tie 1",
        "alku": "2031-12-22T00:00:00",
        "loppu": "2031-12-22T00:00:00",
        "lippu_lukum": 9999
    },
    {
        "tapahtuma_id": 4,
        "tapahtuman_nimi": "Mysteeritapahtuma",
        "paikka": null,
        "katuosoite": null,
        "alku": null,
        "loppu": null,
        "lippu_lukum": 0
    },
    {
        "tapahtuma_id": 5,
        "tapahtuman_nimi": "Karjumisen MM-kisat",
        "paikka": "Tokoinranta",
        "katuosoite": "Eläintarhantie 3",
        "alku": "2024-02-22T18:00:00",
        "loppu": "2024-02-22T21:00:00",
        "lippu_lukum": 9999
    }
]
```

## Epäonnistuneen pyynnön palautus

__Ehto__: Autentikointi epäonnistuu

__Vastausoodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Ei tulevia tapahtumia

__Vastauskoodi__: `404 NOT FOUND`

__Sisältöesimerkki__: 

```json
{
...
    "message": "Ei tulevia tapahtumia",
...
}
```
