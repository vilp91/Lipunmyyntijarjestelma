# Poista yksittäinen lipputyyppi

Poistaa yksittäisen lipputyypin kaikkine tietoineen.

__URL__: `/lipputyypit/{id}`

__METODI__: `DELETE`

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `204 NO CONTENT`

__Esimerkkejä poistettavista tietueista__:

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
