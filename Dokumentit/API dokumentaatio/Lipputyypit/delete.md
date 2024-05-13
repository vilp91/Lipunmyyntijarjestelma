# Poista yksittäinen lipputyyppi

Poistaa yksittäisen lipputyypin kaikkine tietoineen, kun käyttäjällä on vaadittavat oikeudet.

**URL**: `/lipputyypit/{id}`

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `204 NO CONTENT`

## Epäonnistuneen pyynnön palautus

**Ehto**: {id} arvoa ei löydy tietokannasta.

**Vastauskoodi**: `404 NOT FOUND`

```json
{
  "timestamp": "2024-05-13T11:45:25.410+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Lipputyyppiä id:llä 42 ei löydy",
  "path": "/lipputyypit/42"
}
```

TAI

**Ehto**: Autentikointi epäonnistuu

**Vastauskoodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Vastauskoodi**: `403 FORBIDDEN`
