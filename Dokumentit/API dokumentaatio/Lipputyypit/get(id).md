# Hae yksittäisen lipputyypin tiedot

Hakee lipputyypin id:n perusteella yhden lipputyypin.

**URL**: `/lipputyypit/{id}`

**Metodi**: `GET`

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

## Epäonnistunut pyyntö

**Ehto**: Haetaan id:n perusteella lipputyyppiä, mutta lipputyyppiä haetulla id:llä ei ole olemassa.

**Koodi**: `404 NOT FOUND`

**Sisältöesimerkki**:

Tehdään GET pyyntö /lipputyypit/3 endpointtiin. Saadaan seuraava vastaus:

```json
Lipputyyppiä syötetyllä id:llä: 3, ei löydy :(
```
