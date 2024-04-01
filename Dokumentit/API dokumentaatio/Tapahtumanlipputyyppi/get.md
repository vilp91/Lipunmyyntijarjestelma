# Hae kaikki tapahtumanlipputyypit

Hakee kaikki luodut tapahtumanlipputyypit.

**URL**: `/tapahtumanlipputyypit`

**Metodi**: `GET`

__Autentikointi vaaditaan__: Kyllä

**Vaadittavat oikeudet**: Ei mitään

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkki**:

```json
[
    {
        "tapahtuman_lipputyyppi_id": 1,
        "hinta": 10.0,
        "tapahtuma": {
            "tapahtuma_id": 1,
            "tapahtuman_nimi": "Sukankudontakilpailu",
            "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
            "katuosoite": "Kuninkaantammentie 19",
            "alku": "2024-04-06T14:00:00",
            "loppu": "2024-04-06T16:00:00",
            "lippu_lukum": 10,
            "myydyt_liput_lukum": 0
        },
        "lipputyyppi": {
            "lipputyyppi_id": 1,
            "tyyppi": "perus"
        }
    },
    {
        "tapahtuman_lipputyyppi_id": 2,
        "hinta": 10.0,
        "tapahtuma": {
            "tapahtuma_id": 2,
            "tapahtuman_nimi": "Kekkosen synttärit",
            "paikka": "Vaasa",
            "katuosoite": "Vaasankatu 1",
            "alku": "2024-06-12T17:00:00",
            "loppu": "2024-06-12T23:59:00",
            "lippu_lukum": 667,
            "myydyt_liput_lukum": 0
        },
        "lipputyyppi": {
            "lipputyyppi_id": 1,
            "tyyppi": "perus"
        }
    }
]
```

**Epäonnistuneen pyynnön palautus**

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`