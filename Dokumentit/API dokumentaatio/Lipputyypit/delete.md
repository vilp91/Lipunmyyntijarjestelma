# Poista yksittäinen lipputyyppi

Poistaa yksittäisen lipputyypin kaikkine tietoineen, kun käyttäjällä on vaadittavat oikeudet.

__URL__: `/lipputyypit/{id}`

__METODI__: `DELETE`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Admin

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

TAI

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Vastauskoodi__: `403 FORBIDDEN`