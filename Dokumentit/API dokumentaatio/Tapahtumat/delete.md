# Poista yksittäinen tapahtuman

Poistaa yksittäisen tapahtuman kaikkine tietoineen.

__URL__: `/tapahtumat/{id}`

__METODI__: `DELETE`

__Onnistuneen deleten vastauskoodi__: `200 OK`

__Esimerkkejä poistettavista tietueista__:

```Json
{
"tapahtuma_id":5,  
"tapahtuman_nimi":"Karjumisen MM-kisat",  "paikka":"Tokoinranta",  
"katuosoite":"Eläintarhantie 3",  
"alku":"2024-04-22","loppu":"2024-04-22",  "lippu_lukum":9999
}


