# Luodaan uusi tapahtuma

**URL** : `tapahtumat/`

**Metodi** : `POST`

**Autentikaatio** : EI

**Lupia vaadittu** : Ei mitään

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

**Ehto:** Uusi tapahtuma luotiin onnistuneesti.

**Koodi:** `200 OK`

**Esimerkkisisältö:** Uusi tapahtuma luotu

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

**Ehto:** Syntaksi virhe. Esimerkiksi kirjaimia numero kentällä.

**Koodi:** `400 BAD REQUEST`

**Esimerkkisisältö:** Uusi tapahtuma luotu, mutta numero kentässä kirjaimia.

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

**Ehto**: Vaadittu tieto puuttuu

**Koodi**: `400 BAD REQUEST`