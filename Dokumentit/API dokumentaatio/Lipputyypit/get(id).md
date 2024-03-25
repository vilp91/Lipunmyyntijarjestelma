# Hae yksittäisen lipputyypin tiedot

Hakee lipputyypin id:n perusteella yhden lipputyypin.

**URL**: `/lipputyypit/{id}`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Ei mitään


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

**Koodi**: `404 NOT FOUND`

TAI

__Ehto__: Autentikointi epäonnistuu

__Koodi__: `401 UNAUTHORIZED`


**Sisältöesimerkki**:

Tehdään GET pyyntö /lipputyypit/3 endpointtiin. Saadaan seuraava vastaus:

```json
Lipputyyppiä syötetyllä id:llä: 3, ei löydy :(
```
