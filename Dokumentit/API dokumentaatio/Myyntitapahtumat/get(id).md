# Hae yksittäinen myyntitapahtuma

Hakee myyntitapahtuman id:n perusteella yhden myyntitapahtuman.

**URL**: `/myyntitapahtumat/{id}`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Ei mitään

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkejä**:

Haetaan myyntitapahtuma id:n perusteella.

```json
{
  "id": 1,
  "summa": 20.0,
  "aika": "2024-03-04T17:12:40.202629",
  "liput": [
    {
      "id": 1,
      "tyyppi": "perus",
      "tapahtuma": "Sukankudontakilpailu",
      "hinta": 10.0
    },
    {
      "id": 2,
      "tyyppi": "perus",
      "tapahtuma": "Sukankudontakilpailu",
      "hinta": 10.0
    }
  ]
}
```

## Epäonnistunut pyyntö

**Ehto**: Haetaan id:n perusteella myyntitapahtumaa, mutta myyntitapahtumaa haetulla id:llä ei ole olemassa.

**Koodi**: `404 NOT FOUND`

**Sisältöesimerkki**:

Tehdään GET pyyntö /myyntitapahtumat/10 endpointtiin. Saadaan seuraava vastaus:

```json
{
...
    "message": "Myyntitapahtumaa syötetyllä id:llä '10'', ei löydy",
...
}
```

TAI

__Ehto__: Autentikointi epäonnistuu

__Koodi__: `401 UNAUTHORIZED`