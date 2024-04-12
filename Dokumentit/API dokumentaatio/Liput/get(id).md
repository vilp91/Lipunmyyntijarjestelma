# Hae yksittäisen lipun tiedot

Hakee lipun id:n perusteella yhden lipun.

**URL**: `/liput/{id}`

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Vaadittavat oikeudet**: Myyjä tai Admin

## Onnistuneen pyynnön palautus

**Vastauskoodi**: `200 OK`

**Sisältöesimerkki**:

Haetaan lipun tietoja id:n perusteella.

```json
{
  "lippunumero": "64745d3d-490a-49e3-9f60-1e3f1f6b62e2",
  "tapahtumanLipputyyppi": {
      "tapahtumanLipputyyppiId": 1,
      "hinta": 10.0,
      "tapahtuma": {
          "tapahtumanNimi": "Sukankudontakilpailu",
          "paikka": "Pitkäkosken ulkoilumaja - Helsinki",
          "katuosoite": "Kuninkaantammentie 19",
          "alku": "2024-06-06T14:00:00",
          "loppu": "2024-06-06T16:00:00",
          "lippuLukum": 10,
          "myydytLiputLukum": 2,
          "tapahtuma_id": 1
      },
      "lipputyyppi": {
          "lipputyyppiId": 1,
          "tyyppi": "perus"
      }
  },
  "myyntitapahtuma": {
      "kayttaja": {
          "kayttajaId": 1,
          "rooli": {
              "rooliId": 1,
              "rooli": "ROLE_MYYJA"
          },
          "etunimi": "Teppo",
          "sukunimi": "Testaaja",
          "puhnro": null,
          "katuosoite": null,
          "salasana": "$2a$10$iWu9jKWk.x4BVFHzO/FNTu1PZ5qX0cAy2HtwS05bHBgG8OxBhDA3C",
          "kayttajanimi": "teppo"
      },
      "aikaleima": "2024-04-12T23:11:14.775349",
      "myyntitapahtuma_id": 1
  },
  "hinta": 10.0,
  "kaytetty": null,
  "lippu_id": 1
}
```

## Epäonnistunut pyyntö

**Ehto**: Haetaan id:n perusteella lippua, mutta lippua haetulla id:llä ei ole olemassa.

**Vastauskoodi**: `404 NOT FOUND`

TAI

**Ehto**: Autentikointi epäonnistuu

**Koodi**:: `401 UNAUTHORIZED`

TAI

**Ehto**: Autentikoidulla käyttäjällä ei ole vaadittuja oikeuksia

**Koodi**:: `403 FORBIDDEN`


**Sisältöesimerkki**:

Tehdään GET pyyntö /liput/35 endpointtiin. Saadaan seuraava vastaus:

```json
    "message": "Lippua syötetyllä id:llä: 35, ei löydy",
```


TAI

__Ehto__: Autentikointi epäonnistuu

__Vastauskoodi__: `401 UNAUTHORIZED`

