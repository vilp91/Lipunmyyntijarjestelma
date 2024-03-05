# Luo uuden lipputyypin

Luo tapahtumalle uuden lipputyypin.

__URL__: `/lipputyypit`

__Metodi__: `POST`

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `200 OK`

__Sisältöesimerkkejä__:
Luodut lipputyypit.
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
## Epäonnistuneen pyynnön palautus

__Ehto__: lipputyyppi oli jo tietokannassa. Ei voi luoda duplikaattia.

__Vastauskoodi__: `403 Forbidden`