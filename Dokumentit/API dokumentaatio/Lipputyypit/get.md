# Hae lipputyypit

Hakee ja näyttää kaikki tietokannassa olevat lipputyypit tietoineen

__URL__: `/lipputyypit`

__Metodi__: `GET`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Ei mitään

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `200 OK`

__Sisältöesimerkkejä__:

Haetaan tallennetut lipputyypit.
```json
[
    {
        "lipputyyppi_id": 1,
        "tyyppi": "perus"
    },
    {
        "lipputyyppi_id": 2,
        "tyyppi": "lapsi"
    }
]
```
TAI

Tallennettuja lipputyyppejä ei ole.

```json
[]
```

## Epäonnistuneen pyynnön palautus

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`
