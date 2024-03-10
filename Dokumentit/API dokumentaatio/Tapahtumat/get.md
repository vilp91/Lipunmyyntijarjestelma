# Hae kaikki tapahtumat

Hakee ja näyttää kaikki tietokannassa olevat tapahtumat saatavissa olevine tietoineen.

__URL__: `/tapahtumat`

__Metodi__: `GET`

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `200 OK`

__Sisältöesimerkkejä__:

```json
[
    {
        "tapahtuma_id": 2,
        "tapahtuman_nimi": "Kekkosen synttärit",
        "paikka": "Vaasa",
        "katuosoite": "Vaasankatu 1",
        "alku": "2024-06-12T17:00:00",
        "loppu": "2024-06-12T23:59:00",
        "lippu_lukum": 667,
        "tapahtuman_lipputyypit": [
            {
                "hinta": 10.0,
                "tapahtuma": 2,
                "lipputyyppi": 2
            }
        ]
    },
    {
        "tapahtuma_id": 3,
        "tapahtuman_nimi": "Cheek - Paluu areenalle",
        "paikka": "Olympiastadion - Helsinki",
        "katuosoite": "Paavo Nurmen tie 1",
        "alku": "2031-12-22T12:30:00",
        "loppu": "2031-12-22T14:15:00",
        "lippu_lukum": 9999,
        "tapahtuman_lipputyypit": [
            {
                "hinta": 7.0,
                "tapahtuma": 3,
                "lipputyyppi": 3
            },
            {
                "hinta": 10.0,
                "tapahtuma": 3,
                "lipputyyppi": 4
            }
        ]
    }
]
```

## Muistiinpanoja

- tapahtuma_id generoituu automaattisesti ja on juokseva luku.