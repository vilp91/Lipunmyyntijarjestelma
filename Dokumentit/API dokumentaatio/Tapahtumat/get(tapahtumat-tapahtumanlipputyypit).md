# Hae yksittäisen tapahtuman tapahtumanlipputyypit

Hakee kaikki tietokannassa olevat lipputyypit, jotka liittyvät määritettyyn tapahtumaan

__URL__: `/tapahtumat/{id}/tapahtumanlipputyypit`

__Metodi__: `GET`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Myyjä tai Admin

## Onnistuneen pyynnön palautus

__Ehto__: Autentikointi onnistuu ja käyttäjälle näytetään tulokset.

__Vastauskoodi__: `200 OK`

__Esimerkkisisältö__:
```json
[
    {
        "id": 2,
        "hinta": 10.0,
        "tapahtuma": 2,
        "lipputyyppiId": 1,
        "lipputyyppi": "perus"
    }
]
```

TAI

__Ehto__: Autentikointi onnistuu ja tapahtumaan ei ole liitetty tapahtumanlipputyyppejä.

__Vastauskoodi__: `200 OK`

__Sisältö__: `[]`

## Epäonnistuneen pyynnön palautus

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Vastauskoodi__: `403 FORBIDDEN`

TAI

__Ehto__: Tapahtumaa ei ole olemassa

__Vastauskoodi__: `404 NOT FOUND`

__Sisältöesimerkki__: 

Tehdään GET pyyntö /tapahtumat/30/liput endpointtiin. Saadaan seuraava vastaus:

```json
{
...
    "message": "Tapahtumaa id:llä '30' ei löytynyt",
...
}
```
