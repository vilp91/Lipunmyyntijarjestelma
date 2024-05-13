# Poista yksittäinen myyntitapahtuma

Poistaa yksittäisen myyntitapahtuman ja siihen liittyvät liput.

**URL**: `/myyntitapahtumat/{id}`

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `204 NO CONTENT`

## Epäonnistuneen pyynnön palautus

**Ehto**: {id} -arvoa ei löydy tietokannasta

**Vastauskoodi**: `404 NOT FOUND`

```json
{
  "timestamp": "2024-05-13T11:23:46.127+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Myyntitapahtumaa syötetyllä id:llä '126', ei löydy :(",
  "path": "/myyntitapahtumat/126"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`
