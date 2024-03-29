# Luo uuden lipputyypin

Luo tapahtumalle uuden lipputyypin, kun käyttäjällä on vaadittavat oikeudet.

__URL__: `/lipputyypit`

__Metodi__: `POST`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Admin

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
## Epäonnistuneen pyynnön palautus

__Ehto__: Pakollinen tieto puuttuu

__Vastauskoodi__: `400 BAD REQUEST`

__Esimerkkisisältö__:

```json
    "defaultMessage": "Lipputyypin tyyppi on pakollinen tieto"
```
TAI

__Ehto__: Autentikointi epäonnistuu

__Koodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Koodi__: `403 FORBIDDEN`

<!-- __Ehto__: lipputyyppi oli jo tietokannassa. Ei voi luoda duplikaattia.

__Vastauskoodi__: `403 Forbidden` -->