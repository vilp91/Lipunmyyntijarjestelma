# Päivitä yksittäinen lipputyyppi

Päivittää yksittäisen lipputyypin tietoineen, kun käyttäjällä on vaadittavat oikeudet.

__URL__: `/lipputyypit/{id}`

__METODI__: `PUT`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Admin

Anna päivitettävän lipputyypin tiedot:

```json
{
        "tyyppi": "[string]"
}
```

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

TAI

__Ehto__: Pakollinen tieto puuttuu

__Vastauskoodi__: `400 BAD REQUEST`

__Esimerkkisisältö__:

```json
{
    "defaultMessage": "Lipputyypin tyyppi on pakollinen tieto"
}
```

TAI

__Ehto__: lipputyyppi oli jo tietokannassa. Ei voida luoda kaksoikappaletta.

__Vastauskoodi__: `400 BAD REQUEST`


TAI

__Ehto__: Autentikointi epäonnistuu

__Koodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Koodi__: `403 FORBIDDEN`
