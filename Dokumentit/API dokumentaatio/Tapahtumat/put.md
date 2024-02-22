# Päivitä tapahtuma

Päivittää olemassa olevan tapahtuman

URL: `/tapahtumat/{id}`

Metodi: `PUT`

<!-- Autentikointi vaadittu: `KYLLÄ` -->

<!-- Tarvittava käyttöoikeus: ?? -->

Tietosisältöesimerkki:
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

Ehto: Tapahtuma on olemassa ja sen päivitys onnistui

Koodi: `200 OK`

Esimerkkisisältö, kun tapahtuman_nimi on päivitetty pyynnöllä `/tapahtumat/1`:
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

Ehto: Tapahtumaa ei ole olemassa

Koodi: `404 NOT FOUND`

Sisältö: `{}`

<!-- TAI

Ehto: Käyttäjällä ei ole oikeutta päivittää tapahtumaa

Koodi: `403 FORBIDDEN`

Sisältö: `{}` -->

## Lisätiedot

### Huomiotta jätettävät tiedot

Pyynnön mukana annetut epäoleelliset tiedot, kuten tapahtuma_id tai ylimääräiset parametrit jätetään endpointissa huomiotta.

Tietosisältöesimerkki URL:iin `/tapahtumat/1`

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
Koodi: `200 OK`

Esimerkkivastaus
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
´´´

