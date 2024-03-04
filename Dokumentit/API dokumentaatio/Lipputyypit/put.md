# Päivitä yksittäinen lipputyyppi

Päivittää yksittäisen lipputyypin tietoineen.

__URL__: `/lipputyypit/{id}`

__METODI__: `PUT`

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `200 OK`

__Esimerkkejä päivitetyistä tietueista__:

```Json
    {
        "lipputyyppi_id": 1,
        "tyyppi": "perus"
    }
```
```json
    {
        "lipputyyppi_id": 2,
        "tyyppi": "lapsi"
    }
```
## Epäonnistuneen pyynnön palautus

__Ehto__: {id} arvoa ei löydy tietokannasta.

__Vastauskoodi__: `404 NOT FOUND`

