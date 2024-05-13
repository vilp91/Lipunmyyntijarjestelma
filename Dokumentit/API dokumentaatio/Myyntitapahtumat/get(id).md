# Hae yksittäinen myyntitapahtuma

Hakee myyntitapahtuman id:n perusteella yhden myyntitapahtuman.

**URL**: `/myyntitapahtumat/{id}`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkejä**:

Haetaan myyntitapahtuma id:n perusteella.

```json
{
  "id": 122,
  "summa": 50.0,
  "aika": "2024-05-13T08:34:45.8146",
  "kayttajaId": 29,
  "liput": [
    {
      "id": 271,
      "lippunumero": "94fd961e-9f55-45c4-aee4-af6a06803b95",
      "tyyppi": "perus",
      "tapahtuma": "Karjumisen MM-kisat",
      "hinta": 25.0
    },
    {
      "id": 272,
      "lippunumero": "441a7644-b6aa-4df8-808b-8e2d8dd16ccd",
      "tyyppi": "perus",
      "tapahtuma": "Karjumisen MM-kisat",
      "hinta": 25.0
    }
  ]
}
```

## Epäonnistunut pyyntö

**Ehto**: Haetaan id:n perusteella myyntitapahtumaa, mutta myyntitapahtumaa haetulla id:llä ei ole olemassa.

**Vastauskoodi**: `404 NOT FOUND`

**Sisältöesimerkki**:

Tehdään GET pyyntö /myyntitapahtumat/10 endpointtiin. Saadaan seuraava vastaus:

```json
{
  "timestamp": "2024-05-13T11:12:52.833+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Myyntitapahtumaa syötetyllä id:llä '10'', ei löydy",
  "path": "/myyntitapahtumat/10"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
