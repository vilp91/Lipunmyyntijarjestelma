# Lipunmyyntijärjestelmä projektidokumentaatio

Tiimi: Satu Kulta, Ville Pajukangas, Ali Romar, Tuukka Teilas

## Johdanto

Asiakasyrityksenä toiminut lipputoimisto on tilannut lipunmyyntijärjestelmän backend toteutuksen sekä MVP esimerkki toteutukset lipunmyyntiä ja lipuntarkastusta toteuttavista front end clienteista. Tilattu järjestelmä mahdollistaa lipunmyynnin myyntipisteessä, jossa lippupisteen myyjä voi myydä ja tulostaa liput asiakkaille. Järjestelmän avulla toimisto/tapahtumia hallinnoiva taho voi määritellä myytävät tapahtumat aikoineen, paikkoineen sekä lipputyyppineen ja hallita sekä seurata lippujen myyntiä. Järjestelmä mahdollistaa myös ennakkomyynnin päättyessä loppujen lippujen tulostamisen myytäväksi ovella. Tulostettavassa lipussa on yksilöllinen tarkastuskoodi. Tämä koodi voidaan muuttaa esimerkiksi QR-koodiksi, joka helpottaa lippujen tarkastusta ovella. 

Järjestelmän palvelinpuolen toiminnot on toteutettu Javalla Spring Boot -kehystä käyttäen. Tämä valinta mahdollistaa tehokkaan ja joustavan palvelimen toiminnallisuuden rakentamisen, joka tukee tarvittavia REST-palveluita ja tietokantatoiminnallisuuksia. Tietokantana käytetään MySQL:ää.

Käyttöliittymä on selainpohjainen React-sovellus, joka tarjoaa nykyaikaisen ja responsiivisen käyttökokemuksen.

## Järjestelmän määrittely

### Käyttäjäryhmät

- Tapahtumien hallinnoija/"toimisto"

  - Yrityksen sisäinen, toimistolla tai etänä työskentelevä käyttäjä, joka pystyy luomaan lipunmyyntijärjestelmään uusia tapahtumia ja määrittelemään niiden tiedot sekä muokkaamaan olemassa olevia tapahtumia ja muodostamaan erilaisia raportteja tapahtumista ja niiden lipunmyynnistä.

- Lippupisteen myyjä

  - Fyysisessä lipunmyyntipisteessä työskentelevä henkilö, joka käyttää lipunmyyntijärjestelmän myyntipuolta etäyhteydellä erillisen päätelaitteen avulla. Myy tapahtumiin lippuja.

- Lipuntarkastaja

  - Fyysisesti tapahtuman sisäänkäynnillä työskentelevä henkilö, joka tarkastaa tapahtumaan saapuvan asiakkaan lipun ja merkkaa sen käytetyksi.

- Järjestelmän ylläpitäjä

  - Yrityksen sisäinen tai ulkopuolinen henkilö, joka ylläpitää järjestelmän toimivuutta ja mahdollisesti päivittää sitä. Hallinnoi käyttäjätietoja.

### Käyttötapauskaavio

Alla olevassa käyttötapauskaaviossa kuvataan järjestelmän käyttäjät ja yleisimmät perustoiminnot.

![Käyttötapauskaavio](/Dokumentit/Kaaviot//käyttötapauskaavio.png "Käyttötapauskaavio")

### Käyttäjätarinat

- Järjestelmän tilaajana haluan pystyä luomaan ja muokkaamaan tapahtumia

- Järjestelmän tilaajana haluan pystyä myymään lippuja järjestämiini tapahtumiin

- Tapahtumien hallinnoijana haluan pystyä määrittelemään eri käyttäjäryhmille eri hintaisia lippuja, jotta voimme kohdentaa markkinointia

- Järjestelmän tilaajana haluan pystyä luomaan myymättä jääneet liput, jotta ne voidaan myydä tapahtumapaikan ovella

- Markkinointijohtajana haluan pystyä tulostamaan myyntiraportteja, jotta voin käyttää tätä dataa tulevien tapahtumien suunnitteluun

- Järjestelmän tilaajana haluan voida perustaa uusia käyttäjiä, jotta uudet työntekijät pääsevät käyttämään järjestelmää

- Järjestelmän tilaajana haluan voida muokata käyttäjän tietoja, jotta työntekijöiden tiedot pysyvät ajantasalla

- Järjestelmän tilaajana haluan voida poistaa käyttäjiä, jotta tietoturva säilyy työsuhteiden päätyttyä

## Käyttöliittymä

![Käyttöliittymäkaavio](/Dokumentit/Kaaviot/käyttöliittymäkaavio.png "Käyttöliittymäkaavio")

Ylläoleva käyttöliittymäkaavio perustuu asiakkaan toimittamiin wireframe malleihin, eikä vastaa mitään toteutettua front end clientia. Näitä wireframe malleja on kuitenkin käytetty pohjana tuotteen palvelinpuolen toteutusta suunniteltaessa ja toteutettaessa.

Seuraavista alaotsikoista löytyy käyttöliittymäkuvia sekä ohjeistusta lipunmyynnistä, että lipuntarkastuksesta tehtyihin referenssitoteutuksiin. Alla on myös molempien toteutuksien yhteinen kirjautumissivu, josta on mahdollista valita lipuntarkastuksen (Gate Guard) ja -myynnin paikallinen tai verkossa erillisellä palvelimella pyörivä toteutus.

![FrontClientsMenu](/Dokumentit/Kaaviot/Kuvat/FrontClientsMenu.JPG "Referenssitoteutusten päävalikko") 

### Lipunmyynti

![LipunmyyntiLogin](/Dokumentit/Kaaviot/Kuvat/LipunmyyntiLogin.JPG "Login")  
Lipunmyynnin kirjautumissivu.

---
![LipunmyyntiMain](/Dokumentit/Kaaviot/Kuvat/LipunmyyntiMain.JPG "Lipunmyynnin live version pääsivu")  
Lipunmyynnin live version pääsivu.
Täältä käyttäjä(lipunmyyjä) näkee saatavilla olevat tapahtumat, niiden lippumärät sekä muut tarpeelliset tiedot. Alasvetovalikoista voi valita tapahtumaan liput lipputyypeittäin ja myydä ne alareunan Tallenna -painikkeella. Palaa -painike nollaa käyttöliittymän tilan.

---
![LipunmyyntiMyyntitapahtuma](/Dokumentit/Kaaviot/Kuvat/LipunmyyntiMyyntitapahtuma.JPG "Myyntitapahtuman esimerkki")  
Esimerkki onnistuneesta myyntitapahtumasta. Koodi on kullekin lipulle luotava yksilöllinen UUID tunniste, jota voi hyödyntää esimerkiksi QR-koodin generoimisessa lipuntarkastusta varten.



### Lipuntarkastus (Gate Guard)

![LipuntarkastusMain](/Dokumentit/Kaaviot/Kuvat/LipuntarkastusMain.JPG "Lipuntarkastus pääsivu")  
Lipuntarkastuksen pääsivu. Kenttään syötetään validi lippukoodi, jota verrataan tietokannasta löytyviin koodeihin.  

---
![LipuntarkastusLippu](/Dokumentit/Kaaviot/Kuvat/LipuntarkastusLippu.JPG "Lipun tiedot")  
Kun kenttään on syötetty validi lippukoodi ja painettu Check -painiketta, järjestelmä palauttaa lipun tiedot ja antaa mahdollisuuden merkitä lippu käytetyksi painamalla Merkitse käytetyksi -painiketta.  

---
![LipuntarkastusKaytetty](/Dokumentit/Kaaviot/Kuvat/LipuntarkastusKaytetty.JPG "Lippu käytetty")  
Kun lippu on merkitty käytetyksi, järjestelmä ilmoittaa sen ja antaa mahdollisuuden syöttää seuraavan lipun koodi.


## _Tietokanta_

![Tietokantakaavio](/Dokumentit/Kaaviot/tietokantakaavio.png "tietokantakaavio")

> ### _Tapahtuma_
>
> _Tapahtuma-taulu sisältää tapahtumat. Tapahtumaan voi olla monta lippua. Tapahtuma kuuluu aina vain yhdelle tapahtumajärjestäjälle ja tapahtumalla on oltava postinumero._
>
> | Kenttä          | Tyyppi       | Kuvaus                                   |
> | --------------- | ------------ | ---------------------------------------- |
> | tapahtuma_id    | int PK       | tapahtuman id                            |
> | tapahtuman_nimi | varchar(100) | tapahtuman nimi                          |
> | paikka          | varchar(100) | tapahtumapaikka                          |
> | katuosoite      | varchar(100) | tapahtumapaikan katuosoite               |
> | alku            | date         | tapahtuman alkuaika                      |
> | loppu           | date         | tapahtuman loppuaika                     |
> | lippu_lkm       | int          | tapahtumaan myytävien lippujen lukumäärä |

<!-- > perushinta | float | tapahtuman lipun perushinta
> jarjestaja_id | int FK |  tapahtuman järjestäjä, viittaus  [tapahtumajarjestaja](#tapahtumajarjestaja) -tauluun
> postinumero_id | varchar (10) FK | tapahtuman postinumero, viittaus [postinumero](#Postinumero)-tauluun -->

<!-- > ### _Tapahtumajarjestaja_
> _Tapahtumajärjestäjä-taulu sisältää tapahtumien järjestäjätahot. Järjestäjällä voi olla monta tapahtumaa ja sillä on oltava postinumero._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> jarjestaja_id | int PK | tapahtumajärjestäjän id
> postinumero_id | varchar(10) FK | tapahtumajärjestäjän postinumero, viittaus [postinumero](#Postinumero)-tauluun
> katuosoite | varchar(100) | tapahtumajärjestäjän osoite
> puh | varchar(20) | tapahtumajärjestäjän puhelinnumero
> sahkoposti | varchar(50) | tapahtumajärjestäjän sähköpostiosoite -->

<!-- > ### _Tapahtumajarjestaja_henkilo_
> _Tapahtumajärjestäjä_henkilö-taulu on tapahtumajärjestäjä-taulun alitaulu ja sisältää lisätiedot yksityishenkilöistä, jotka toimivat tapahtumajärjestäjinä._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> jarjestaja_id | int PK | tapahtumajärjestäjähenkilön id
> etunimi | varchar(50) | tapahtumajärjestäjän etunimi
> sukunimi | varchar(50) | tapahtumajärjestäjän sukunimi
> hetu | varchar(20) | tapahtumajärjestäjän henkilötunnus -->

<!-- > ### _Tapahtumajarjestaja_yritys_
> _Tapahtumajärjestäjä_yritys-taulu on tapahtumajärjestäjä-taulun alitaulu ja sisältää lisätiedot yrityksistä, jotka toimivat tapahtumajärjestäjinä._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> jarjestaja_id | int PK | tapahtumajärjestäjäyrityksen id
> nimi | varchar(100) | yrityksen nimi
> yhteyshenk_etunimi | varchar(50) | yrityksen yhteyshenkilön etunimi
> yhteyshenk_sukunimi | varchar(50) | yrityksen yhteyshenkilön sukunimi
> ytunnus | varchar(50) | yrityksen y-tunnus -->

<!-- > ### _Lippu_ // ALKUPERÄINEN
> _Lippu-taulu sisältää tapahtumiin myytävät liput. Lippu kuuluu aina yhteen tapahtumaan ja sillä on aina yksi lipputyyppi._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> lippu_id | varchar(8) PK | lipun id
> lipputyyppi_id | int FK | lipun tyyppi, viittaus [lipputyyppi](#lipputyyppi)-tauluun
> tapahtuma_id | int FK | tapahtuma, johon lippu oikeuttaa, viittaus [tapahtuma](#tapahtuma)-tauluun
> hinta | float | lipun hinta -->

> ### _Lippu_
>
> _Lippu-taulu sisältää tapahtumiin myytävät liput. Lippu kuuluu aina yhteen myyntitapahtumaan ja sillä on aina yksi tapahtuman lipputyyppi._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> lippu_id | int PK | lipun id
> tapahtuman_lipputyyppi_id | int FK | lipun tyyppi, viittaus [tapahtuman_lipputyyppi](#tapahtuman_lipputyyppi)-tauluun
> myyntitapahtuma_id | int FK | myyntitapahtuma, johon lippu liittyy, viittaus [myyntitapahtuma](#myyntitapahtuma)-tauluun
> hinta | float | lipun lopullinen hinta, mahdollisine alennuksineen

> ### _Lipputyyppi_
>
> _Lipputyyppi-taulu sisältää lipputyypit. Lipputyyppi voi olla useassa lipussa._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> lipputyyppi_id | int PK | lipputyypin id
> tyyppi | varchar(50) | lipputyypin nimi/kuvaus esim. lastenlippu, eläkeläislippu, jne.

> ### _Tapahtuman_lipputyyppi_
>
> _Tapahtuman_lipputyyppi-taulu sisältää tapahtumiin määritetyt lipputyypit. Tapahtuman lipputyyppi voi olla useassa lipussa. Sillä on aina yksi lipputyyppi ja se kuuluu yhteen tapahtumaan._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> tapahtuman_lipputyyppi_id | int PK | tapahtuman lipputyypin id
> tapahtuma_id | int FK | tapahtuma, johon lipputyyppi liittyy, viittaus [tapahtuma](#tapahtuma)-tauluun
> lipputyyppi_id | int FK | lipputyypin nimi/kuvaus esim. lastenlippu, eläkeläislippu, viittaus [lipputyyppi](#lipputyyppi)-tauluun
> hinta | float | lipputyypin hinta

<!-- > ### _Alennus_  //
> _Alennus-taulu sisältää lipputyyppien alennukset. Alennus on aina yhdellä lipputyypillä._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> alennus_id | int PK | alennuksen id
> lipputyyppi_id | int FK | lipputyyppi, johon alennus on liitetty, viittaus [lipputyyppi](#lipputyyppi) -tauluun
> alennus | float | alennuskerroin -->

<!-- > ### _Postinumero_
> _Postinumero-taulu sisältää postinumerot. Postinumero voi olla usealla käyttäjällä, tapahtumajärjestäjällä ja tapahtumalla ja se liittyy aina yhteen kaupunkiin._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> postinumero_id | varchar(10) | postinumero
> kaupunki_id | int FK | kaupunki, jossa postinumero sijaitsee, viittaus [kaupunki](#kaupunki)-tauluun
> postitoimipaikka | varchar(50) | postitoimipaikka -->

<!-- > ### _Kaupunki_
> _Kaupunki-taulu sisältää kaupungit. Kaupunki liittyy yhteen tai useampaan postinumeroon._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> kaupunki_id | int PK | kaupungin id
> nimi | varchar(50) | kaupungin nimi -->

<!-- > ### _Myyntitapahtuma_ // ALKUPERÄINEN
> _Myyntitapahtuma-taulu sisältää lippujen myyntitapahtumat. Myyntitapahtumaan voi sisältyä useita myyntitapahtumarivejä ja sillä on aina yksi käyttäjä._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> myyntitapahtuma_id | int PK |myyntitapahtuman id
> kayttaja_id | int FK | myyntitapahtuman käyttäjätieto, viittaus [käyttäjä](#kayttaja)-tauluun
> pvm_date | date | myyntitapahtuman tallennuspäivä -->

> ### _Myyntitapahtuma_
>
> _Myyntitapahtuma-taulu sisältää lippujen myyntitapahtumat. Myyntitapahtumalla on aina yksi käyttäjä ja myyntitapahtumaan voi sisältyä useita lippuja._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> myyntitapahtuma_id | int PK |myyntitapahtuman id
> kayttaja_id | int FK | myyntitapahtuman käyttäjätieto, viittaus [käyttäjä](#kayttaja)-tauluun
> pvm_date | date | myyntitapahtuman tallennuspäivä

<!-- > ### _Myyntitapahtumarivi_
> _Myyntitapahtumarivi-taulu sisältää myyntitapahtuman yksittäiset rivit. Rivi kuuluu aina yhteen myyntitapahtumaan ja sisältää aina yhden lipun._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> myyntitapahtumarivi_id | int PK |myyntitapahtumarivin id
> lippu_id | varchar(8) FK | rivillä oleva lippu, viittaus [lippu](#lippu)-tauluun
> myyntitapahtuma_id | int FK | myyntitapahtuma, johon rivi liittyy, viittaus [myyntitapahtuma](#myyntitapahtuma)-tauluun -->

> ### _Kayttaja_
>
> _Käyttäjä-taulu sisältää järjestelmän käyttäjät. Käyttäjällä on aina postinumero ja rooli ja käyttäjä voi liittyä useaan myyntitapahtumaan._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> kayttaja_id | int PK | käyttäjän id
> rooli_id | int FK | käyttäjän rooli, viittaus [rooli](#rooli) -tauluun
> etunimi | varchar(50) | käyttäjän etunimi
> sukunimi | varchar(50) | käyttäjän sukunimi
> puhnro | varchar(20) | käyttäjän puhelinnumero
> katuosoite | varchar(100) | käyttäjän katuosoite

<!-- > postinumero_id | varchar(50) FK | käyttäjän postinumero, viittaus [postinumero](#postinumero)-tauluun -->

> ### _Rooli_
>
> _Rooli-taulu sisältää käyttäjien roolit. Rooli voi liittyä useaan käyttäjään._
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> rooli_id | int PK | käyttäjän id
> rooli | varchar(50) | roolin nimi/kuvaus

## _Tekninen kuvaus_

_Teknisessä kuvauksessa esitetään järjestelmän toteutuksen suunnittelussa tehdyt tekniset
ratkaisut, esim._

- _Missä mikäkin järjestelmän komponentti ajetaan (tietokone, palvelinohjelma)
  ja komponenttien väliset yhteydet (vaikkapa tähän tyyliin:
  https://security.ufl.edu/it-workers/risk-assessment/creating-an-information-systemdata-flow-diagram/)_
- _Palvelintoteutuksen yleiskuvaus: teknologiat, deployment-ratkaisut yms._
- _Keskeisten rajapintojen kuvaukset, esimerkit REST-rajapinta. Tarvittaessa voidaan rajapinnan käyttöä täsmentää
  UML-sekvenssikaavioilla._
- _Toteutuksen yleisiä ratkaisuja, esim. turvallisuus._

_Tämän lisäksi_

- _ohjelmakoodin tulee olla kommentoitua_
- _luokkien, metodien ja muuttujien tulee olla kuvaavasti nimettyjä ja noudattaa
  johdonmukaisia nimeämiskäytäntöjä_
- _ohjelmiston pitää olla organisoitu komponentteihin niin, että turhalta toistolta
  vältytään_

## _Testaus_

_Tässä kohdin selvitetään, miten ohjelmiston oikea toiminta varmistetaan
testaamalla projektin aikana: millaisia testauksia tehdään ja missä vaiheessa.
Testauksen tarkemmat sisällöt ja testisuoritusten tulosten raportit kirjataan
erillisiin dokumentteihin._

_Tänne kirjataan myös lopuksi järjestelmän tunnetut ongelmat, joita ei ole korjattu._

## _Asennustiedot_

_Järjestelmän asennus on syytä dokumentoida kahdesta näkökulmasta:_

- _järjestelmän kehitysympäristö: miten järjestelmän kehitysympäristön saisi
  rakennettua johonkin toiseen koneeseen_

- _järjestelmän asentaminen tuotantoympäristöön: miten järjestelmän saisi
  asennettua johonkin uuteen ympäristöön._

_Asennusohjeesta tulisi ainakin käydä ilmi, miten käytettävä tietokanta ja
käyttäjät tulee ohjelmistoa asentaessa määritellä (käytettävä tietokanta,
käyttäjätunnus, salasana, tietokannan luonti yms.)._

## _Käynnistys- ja käyttöohje_

_Tyypillisesti tässä riittää kertoa ohjelman käynnistykseen tarvittava URL sekä
mahdolliset kirjautumiseen tarvittavat tunnukset. Jos järjestelmän
käynnistämiseen tai käyttöön liittyy joitain muita toimenpiteitä tai toimintajärjestykseen liittyviä asioita, nekin kerrotaan tässä yhteydessä._

_Usko tai älä, tulet tarvitsemaan tätä itsekin, kun tauon jälkeen palaat
järjestelmän pariin !_
