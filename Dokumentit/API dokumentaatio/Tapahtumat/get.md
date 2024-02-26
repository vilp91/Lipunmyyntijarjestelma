# Hae kaikki tapahtumat

Hakee ja näyttää kaikki tietokannassa olevat tapahtumat saatavissa olevine tietoineen.

__URL__: `/tapahtumat`

__Metodi__: `GET`

## Onnistuneen pyynnön palautus

__Vastauskoodi__: `200 OK`

__Sisältöesimerkejä__:

Tapahtumalle, jonka id on 3 paikallisessa tietokannassa ja jonka tietoihin on tallennettu tapahtuman nimi, paikka, katuosoite, alku- sekä loppupäivämäärät ja lippujen lukumäärä.

```json
{
"tapahtuma_id":3,  
"tapahtuman_nimi":"Cheek - Paluu areenalle",  "paikka":"Olympiastadion - Helsinki",  
"katuosoite":"Paavo Nurmen tie 1",  
"alku":"2024-02-22","loppu":"2024-02-22",  "lippu_lukum":9999
}  
```

Tapahtumalle, jonka id on 4 paikallisessa tietokannassa ja jonka tietoihin on tallennettu tapahtuman nimi.

```json
{
"tapahtuma_id":4,  
"tapahtuman_nimi":"Mysteeritapahtuma",
"paikka":null,  
"katuosoite":null,  
"alku":null,
"loppu":null,
"lippu_lukum":0
}  
```

## Muistiinpanoja

- tapahtuma_id generoituu automaattisesti ja on juokseva luku.