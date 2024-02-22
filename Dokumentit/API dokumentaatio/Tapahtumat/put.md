# Päivitä tapahtuma

Päivittää olemassa olevan tapahtuman

__URL__: `/tapahtumat/{id}`

__Metodi__: `PUT`

<!-- Autentikointi vaadittu: `KYLLÄ` -->

<!-- Tarvittava käyttöoikeus: ?? -->

__Tietosisältövaatimukset__:
```json
    {
        "tapahtuman_nimi": "[string]",
        "paikka": "[string]",
        "katuosoite": "[string]",
        "alku_pvm": "[datetime]",
        "loppu_pvm": "[datetime]",
        "lippu_lukum": [int],
    }
```

__Tietosisältöesimerkki__:
```json
    {
        "tapahtuman_nimi": "Sukankudontakilpailu",
        "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
        "katuosoite": "Kuninkaantammentie 19",
        "alku_pvm": "2024-04-02",
        "loppu_pvm": "2024-04-02",
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
    "alku_pvm": "2024-04-02",
    "loppu_pvm": "2024-04-02",
    "lippu_lukum": 50
}
```
## Vastauskoodit - Error

__Ehto__: Tapahtumaa ei ole olemassa

__Koodi__: `404 NOT FOUND`

__Sisältö__: `{}`

<!-- TAI

Ehto: Käyttäjällä ei ole oikeutta päivittää tapahtumaa

Koodi: `403 FORBIDDEN`

Sisältö: `{}` -->

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
    "alku_pvm": "2024-04-02",
    "loppu_pvm": "2024-04-02",
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
    "alku_pvm": "2024-04-02",
    "loppu_pvm": "2024-04-02",
    "lippu_lukum": 50
}
```

