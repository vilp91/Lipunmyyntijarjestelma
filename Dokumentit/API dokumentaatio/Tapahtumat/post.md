# Luodaan uusi tapahtuma

**URL** : `tapahtumat/`

**Metodi** : `POST`

**Autentikaatio** : EI

**Lupia vaadittu** : Ei mitään

Anna luotavan tapahtuman tiedot

```json
{
  "tapahtuma_id": "[int/auto increment]",
  "tapahtuman_nimi": "[string]",
  "paikka": "[string]",
  "katuosoite": "[string]",
  "alku_pvm": "[date]",
  "loppu_pvm": "[date]",
  "lippu_lukum": "[int]"
}
```

## Onnistunut tapahtuma

**Ehto:** Tapahtumaa ei ollut olemassa ja uusi tapahtuma luotiin onnistuneesti.

**Koodi:** `200 OK`

**Esimerkkisisältö:** Uusi tapahtuma luotu

```json
{
  "tapahtuma_id": 1,
  "tapahtuman_nimi": "Tapahtuma",
  "paikka": "Tapahtumapaikka",
  "katuosoite": "Tapahtumaosotie",
  "alku_pvm": "2024-02-28",
  "loppu_pvm": "2024-02-28",
  "lippu_lukum": 100
}
```

## Epäonnistunut tapahtuma

**Ehto:** Syntaxi virhe. Esimerkiksi kirjaimia numero kentällä

**Koodi:** `400 BAD REQUEST`

**Esimerkkisisältö:** Uusi tapahtuma luotu, mutta numero kentässä kirjaimia

```json
{
  "tapahtuma_id": 1,
  "tapahtuman_nimi": "Tapahtuma",
  "paikka": "Tapahtumapaikka",
  "katuosoite": "Tapahtumaosotie",
  "alku_pvm": "2024-02-28",
  "loppu_pvm": "2024-02-28",
  "lippu_lukum": "Testi"
}
```
