# Päivitä tapahtuma

Päivittää olemassa olevan tapahtuman, kun käyttäjällä on vaadittavat oikeudet.

**URL**: `/tapahtumat/{id}`

**Metodi**: `PUT`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

**Tietosisältövaatimukset**:

```json
{
  "tapahtumanNimi": "[string]",
  "paikka": "[string]",
  "katuosoite": "[string]",
  "alku": "[YYYY-MM-DDTHH:mm:ss]",
  "loppu": "[YYYY-MM-DDTHH:mm:ss]",
  "lippuLukum": "[int]"
}
```

**Tietosisältöesimerkki**:

```json
{
  "tapahtumanNimi": "Sukankudontakilpailu",
  "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
  "katuosoite": "Kuninkaantammentie 19",
  "alku": "2024-06-06T14:00:00",
  "loppu": "2024-06-06T16:00:00",
  "lippuLukum": 100
}
```

## Onnistunut tapahtuma

**Ehto**: Tapahtuma on olemassa ja sen päivitys onnistui

**Vastauskoodi**: `200 OK`

**Esimerkkisisältö**, kun tapahtuman_nimi on päivitetty pyynnöllä `/tapahtumat/1`:

```json
{
  "tapahtumaId": 57,
  "tapahtumanNimi": "Päivitetty nimi",
  "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
  "katuosoite": "Kuninkaantammentie 19",
  "alku": "2024-06-06T14:00:00",
  "loppu": "2024-06-06T16:00:00",
  "lippuLukum": 100,
  "myydytLiputLukum": 0
}
```

## Epäonnistunut tapahtuma

**Ehto**: Haetaan id:n perusteella tapahtumaa, mutta tapahtumaa haetulla id:llä ei ole olemassa.

**Vastauskoodi**: `404 NOT FOUND`

**Sisältöesimerkki**:

Tehdään PUT pyyntö /tapahtumat/10 endpointtiin. Saadaan seuraava vastaus:

```json
{
  "timestamp": "2024-05-13T11:05:07.285+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Tapahtumaa id:llä '10' ei löydy",
  "path": "/tapahtumat/10"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`

## Lisätiedot

### Huomiotta jätettävät tiedot

Pyynnön mukana annetut epäoleelliset tiedot, kuten tapahtumaId tai ylimääräiset parametrit jätetään endpointissa huomiotta.

**Tietosisältöesimerkki** URL:iin `/tapahtumat/1`

```json
{
  "tapahtumaId": 6,
  "ylimaarainenParametri": "ylimaarainen tieto",
  "tapahtumanNimi": "Päivitetty nimi",
  "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
  "katuosoite": "Kuninkaantammentie 19",
  "alku": "2024-04-02T14:00:00",
  "loppu": "2024-04-02T16:00:00",
  "lippuLukum": 50
}
```

**Vastauskoodi**: `200 OK`

**Esimerkkivastaus**

```json
{
  "tapahtumaId": 1,
  "tapahtumanNimi": "Päivitetty nimi",
  "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
  "katuosoite": "Kuninkaantammentie 19",
  "alku": "2024-04-02T14:00:00",
  "loppu": "2024-04-02T16:00:00",
  "lippuLukum": 50
}
```
