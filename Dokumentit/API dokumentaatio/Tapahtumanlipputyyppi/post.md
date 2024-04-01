# Luo uuden tapahtumanlipputyypin

Luo uusi tapahtumanlipputyyppi.

__URL__: `/tapahtumanlipputyypit`

__Metodi__: `POST`

__Autentikointi vaaditaan__: Kyllä

__Vaadittavat oikeudet__: Admin

__Esimerkkisisältö__:

```json
{
  "hinta": "[float]",
  "tapahtuma": "[Long]",
  "lipputyyppiId": "[Long]"
}
```

## Onnistuneen pyynnön palautus

__Ehto__: Pyynnössä on valmiiksi olemassa olevat tapahtuma ja lipputyyppi sekä hinta on positiivinen luku.

__Vastauskoodi__: `201 CREATED`

__Esimerkkisisältö__:

```json
{
    "id": 1,
    "hinta": 10.0,
    "tapahtuma": 1,
    "lipputyyppiId": 1,
    "lipputyyppi": "perus"
}
```
## Epäonnistuneen pyynnön palautus

__Ehto__: Pakollinen tieto on virheellinen

__Vastauskoodi__: `400 BAD REQUEST`

__Esimerkkisisältö__:

```json
{
    "hinta": -1,
    "tapahtuma": 1,
    "lipputyyppiId": 1
}
```
__Vastaus__:
```json
"defaultMessage": "Hinnan pitää olla positiivinen arvo"
```
---
__Esimerkkisisältö__:
```json
{
    "hinta": 25.00,
    "tapahtuma": 999,
    "lipputyyppiId": 1
}
```
__Vastaus__:
```json
"defaultMessage": "Tapahtumaa ei ole olemassa"
```
---
__Esimerkkisisältö__:
```json
{
    "hinta": 25.00,
    "tapahtuma": 1,
    "lipputyyppiId": 999
}
```

 __Vastaus__:
```json
    "defaultMessage": "Lipputyypin tyyppi on pakollinen tieto"
```

TAI

__Ehto__: Autentikointi epäonnistuu

__Koodi__: `401 UNAUTHORIZED`

TAI

__Ehto__: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

__Koodi__: `403 FORBIDDEN`

<!-- En jaksanut muuttaa virheviestejä tai tehdä uutta/erillistä sille puuttuuko tieto tai onko se virheellinen. Tänne saa vaikka ja minkälaisia 400 Bad Requesteja ilman virheviestejä ja 500 Internal Server Erroreita Postmanilla jos laittaa noihin kenttiin mitä sattuu arvoja tai jättää koko kentän laittamatta... 
-Ali -->