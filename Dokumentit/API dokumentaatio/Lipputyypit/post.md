# Luo uuden lipputyypin

Luo tapahtumalle uuden lipputyypin.

__URL__: `/lipputyypit`

__Metodi__: `POST`

Anna luotavan lipputyypin tiedot:

```json
{
        "tyyppi": "[string]"
}
```

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `201 CREATED`

__Sisältöesimerkkejä__:

```json
{
    "lipputyyppi_id": 4,
    "tyyppi": "opiskelija"
}
```
<!-- ## Epäonnistuneen pyynnön palautus

__Ehto__: lipputyyppi oli jo tietokannassa. Ei voi luoda duplikaattia.

__Vastauskoodi__: `403 Forbidden` -->