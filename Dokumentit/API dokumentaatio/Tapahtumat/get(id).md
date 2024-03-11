# Hae yksittäisen tapahtuman tiedot

Hakee tapahtuman id:n perusteella yhden tapahtuman.

**URL**: `/tapahtumat/{id}`

**Metodi**: `GET`

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkki**:

Haetaan tapahtumaa id:n perusteella.

```json
{
  "tapahtuma_id": 1,
  "tapahtuman_nimi": "Sukankudontakilpailu",
  "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
  "katuosoite": "Kuninkaantammentie 19",
  "alku": "2024-04-06T14:00:00",
  "loppu": "2024-04-06T16:00:00",
  "lippu_lukum": 10,
  "myydyt_liput_lukum": 0,
  "tapahtuman_lipputyypit": [
    {
      "hinta": 10.0,
      "tapahtuma": 1,
      "lipputyyppi": 1
    }
  ]
}
```

## Epäonnistunut tapahtuma

**Ehto**: Haetaan id:n perusteella tapahtumaa, mutta tapahtumaa haetulla id:llä ei ole olemassa.

**Koodi**: `404 NOT FOUND`

**Sisältöesimerkki**:

Tehdään GET pyyntö /tapahtumat/10 endpointtiin. Saadaan seuraava vastaus:

```json
Tapahtumaa syötetyllä id:llä: 10, ei löydy :(
```
