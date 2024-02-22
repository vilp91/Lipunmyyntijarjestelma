# Luodaan uusi tapahtuma

**URL** : `/localhost:8080/tapahtumat`

**Metodi** : `POST`

**Autentikaatio** : EI

**Lupia vaadittu** : Ei mitään

**Datan rajoitukset**

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
