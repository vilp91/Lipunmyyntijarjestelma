# Poista yksittäinen tapahtuman

Poistaa yksittäisen tapahtuman kaikkine tietoineen.

**URL:** `/tapahtumat/{id}`

**METODI:** `DELETE`

**Onnistuneen deleten vastauskooodi:** `200 OK`

**Epäonnistuneen deleten vastauskoodi:** `404`

**Esimerkkejä poistettavista tietueista:**

```Json
{
"tapahtuma_id":5,  
"tapahtuman_nimi":"Karjumisen MM-kisat",  "paikka":"Tokoinranta",  
"katuosoite":"Eläintarhantie 3",  
"alku_pvm":"2024-04-22","loppu_pvm":"2024-04-22",  "lippu_lukum":9999
}


