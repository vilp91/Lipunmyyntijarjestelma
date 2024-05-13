# Hae yksittäisen lipputyypin tiedot

Hakee lipputyypin id:n perusteella yhden lipputyypin.

**URL**: `/lipputyypit/{id}`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkki**:

Haetaan lipputyypin tietoja id:n perusteella.

```json
{
  "lipputyyppi_id": 1,
  "tyyppi": "perus"
}
```

## Epäonnistuneen pyynnön palautus

**Ehto**: Haetaan id:n perusteella lipputyyppiä, mutta lipputyyppiä haetulla id:llä ei ole olemassa.

**Vastauskoodi**: `404 NOT FOUND`

**Sisältöesimerkki**:

Tehdään GET pyyntö /lipputyypit/3 endpointtiin. Saadaan seuraava vastaus:

```json
{
  "timestamp": "2024-05-13T11:30:46.163+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Lipputyyppiä id:llä 3 ei löydy",
  "path": "/lipputyypit/3"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
