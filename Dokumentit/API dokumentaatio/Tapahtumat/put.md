# Päivitä tapahtuma

Päivittää olemassa olevan tapahtuman, kun käyttäjällä on vaadittavat oikeudet.

__URL__: `/tapahtumat/{id}`

__Metodi__: `PUT`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Admin

__Tietosisältövaatimukset__:
```json
    {
        "tapahtuman_nimi": "[string]",
        "paikka": "[string]",
        "katuosoite": "[string]",
        "alku": "[YYYY-MM-DDTHH:mm:ss]",
        "loppu": "[YYYY-MM-DDTHH:mm:ss]",
        "lippu_lukum": [int],
    }
```

__Tietosisältöesimerkki__:
```json
    {
        "tapahtuman_nimi": "Sukankudontakilpailu",
        "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
        "katuosoite": "Kuninkaantammentie 19",
        "alku": "2024-04-02T14:00:00",
        "loppu": "2024-04-02T16:00:00",
        "lippu_lukum": 50
    }
```

## Vastauskoodit - Success

__Ehto__: Tapahtuma on olemassa ja sen päivitys onnistui

__Koodi__: `200 OK`

__Esimerkkisisältö__, kun tapahtuman_nimi on päivitetty pyynnöllä `/tapahtumat/1`:
```json
{
    "tapahtuma_id": 1,
    "tapahtuman_nimi": "Päivitetty nimi",
    "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
    "katuosoite": "Kuninkaantammentie 19",
    "alku": "2024-04-02T14:00:00",
    "loppu": "2024-04-02T16:00:00",
    "lippu_lukum": 50
}
```
## Vastauskoodit - Error

__Ehto__: Tapahtumaa ei ole olemassa

__Koodi__: `404 NOT FOUND`

__Sisältö__: `{}`

TAI

__Ehto__: Autentikointi epäonnistuu

__Koodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Koodi__: `403 FORBIDDEN`

## Lisätiedot

### Huomiotta jätettävät tiedot

Pyynnön mukana annetut epäoleelliset tiedot, kuten tapahtuma_id tai ylimääräiset parametrit jätetään endpointissa huomiotta.

__Tietosisältöesimerkki__ URL:iin `/tapahtumat/1`

```json
{
    "tapahtuma_id": 6,
    "ylimaarainen_parametri": "ylimaarainen tieto",
    "tapahtuman_nimi": "Päivitetty nimi",
    "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
    "katuosoite": "Kuninkaantammentie 19",
    "alku": "2024-04-02T14:00:00",
    "loppu": "2024-04-02T16:00:00",
    "lippu_lukum": 50
}
```
__Koodi__: `200 OK`

__Esimerkkivastaus__
```json
{
    "tapahtuma_id": 1,
    "tapahtuman_nimi": "Päivitetty nimi",
    "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
    "katuosoite": "Kuninkaantammentie 19",
    "alku": "2024-04-02T14:00:00",
    "loppu": "2024-04-02T16:00:00",
    "lippu_lukum": 50
}
```

