# Hae yksittäinen tapahtumanlipputyyppi

Hakee tapahtumanlipputyypin id:n perusteella yhden tapahtumanlipputyypin.

**URL**: `/tapahtumanlipputyypit/{id}`

**Metodi**: `GET`

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkki**:

```json
{
    "hinta": 10.0,
    "tapahtuma": 2,
    "lipputyyppi": 2
}
```

## Epäonnistuneen pyynnön palautus

**Ehto**: Haetaan tapahtumanlipputyyppiä, jota ei ole olemassa.

**Koodi**: `404 NOT FOUND`