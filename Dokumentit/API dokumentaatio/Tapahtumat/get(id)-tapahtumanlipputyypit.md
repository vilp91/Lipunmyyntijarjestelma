# Hae yksittäisen tapahtuman tapahtumanlipputyypit

Hakee kaikki tietokannassa olevat lipputyypit, jotka liittyvät määritettyyn tapahtumaan

__URL__: `/tapahtumat/{id}/tapahtumanlipputyypit`

__Metodi__: `GET`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Ei mitään

## Onnistuneen pyynnön palautus

__Ehto__: Autentikointi onnistuu ja käyttäjälle näytetään tulokset.

__Koodi__: `200 OK`

__Esimerkkisisältö__:
```json
[
    {
        "id": 2,
        "hinta": 10.0,
        "tapahtuma": 2,
        "lipputyyppi": 1
    }
]
```

TAI

__Ehto__: Autentikointi onnistuu ja tapahtumaan ei ole liitetty tapahtumanlipputyyppejä.

__Koodi__: `200 OK`

__Sisältö__: `[]`

## Epäonnistuneen pyynnön palautus

__Ehto__: Autentikointi epäonnistuu

__Koodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Tapahtumaa ei löydy

__Koodi__: `404 NOT FOUND`

