# Hae käyttäjät

Hakee kaikki tietokannassa olevat käyttäjät tietoineen

**URL**: `/kayttajat"`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Admin

## Onnistuneen pyynnön palautus

**

**Vastauskoodi**: `200 OK`

**Sisältöesimerkkejä**:

Haetaan liput.

```json
[
    {
        "kayttaja_id": 1,
        "etunimi": "Teppo",
        "sukunimi": "Testaaja",
        "puhnro": "0401231231",
        "katuosoite": "Testikatu 2"
    },
    {
        "kayttaja_id": 2,
        "etunimi": "Heikki",
        "sukunimi": "Hallinnoija",
        "puhnro": "0404564564",
        "katuosoite": "Hallinnoijakatu 1"
    }
]```

## Epäonnistunut pyyntö

**Ehto**: Autentikointi epäonnistuu

**Koodi**: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Koodi**: `403 FORBIDDEN`
