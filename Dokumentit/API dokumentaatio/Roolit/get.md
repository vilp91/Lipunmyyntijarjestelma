# Hae roolit

Hakee kaikki tietokannassa olevat roolit tietoineen

**URL**: `/roolit"`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

## Onnistuneen pyynnön palautus

**

**Vastauskoodi**: `200 OK`

**Sisältöesimerkkejä**:

```json
[
    {
        "rooli_id": 1,
        "rooli": "ROLE_MYYJA"
    },
    {
        "rooli_id": 2,
        "rooli": "ROLE_ADMIN"
    }
]
```

## Epäonnistunut pyyntö

**Ehto**: Autentikointi epäonnistuu

**Koodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Koodi**: `403 FORBIDDEN`
