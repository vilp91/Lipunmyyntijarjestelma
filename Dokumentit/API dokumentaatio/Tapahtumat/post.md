# Luodaan uusi tapahtuma

__URL__: `tapahtumat/`

__Metodi__: `POST`

__Autentikaatio__: EI

__Lupia vaadittu__: Ei mitään

Anna luotavan tapahtuman tiedot

```json
{
  "tapahtuman_nimi": "[string]",
  "paikka": "[string]",
  "katuosoite": "[string]",
  "alku": "[date]",
  "loppu": "[date]",
  "lippu_lukum": "[int]"
}
```

## Onnistunut tapahtuma

__Ehto__: Uusi tapahtuma luotiin onnistuneesti.

__Koodi__: `200 OK`

__Esimerkkisisältö__: Uusi tapahtuma luotu

```json
{
  "tapahtuma_id": 1,
  "tapahtuman_nimi": "Tapahtuma",
  "paikka": "Tapahtumapaikka",
  "katuosoite": "Tapahtumaosotie",
  "alku": "2024-02-28",
  "loppu": "2024-02-28",
  "lippu_lukum": 100
}
```

## Epäonnistunut tapahtuma

__Ehto__: Syntaksi virhe. Esimerkiksi kirjaimia numero kentällä.

__Koodi__: `400 BAD REQUEST`

__Esimerkkisisältö__: Uusi tapahtuma luotu, mutta numero kentässä kirjaimia.

```json
{
  "tapahtuma_id": 1,
  "tapahtuman_nimi": "Tapahtuma",
  "paikka": "Tapahtumapaikka",
  "katuosoite": "Tapahtumaosotie",
  "alku": "2024-02-28",
  "loppu": "2024-02-28",
  "lippu_lukum": "Testi"
}
```
TAI

__Ehto__: Vaadittu tieto puuttuu

__Koodi__: `400 BAD REQUEST`