# _TicketGuru_

Tiimi: Satu Kulta, Ville Pajukangas, Ali Romar, Tuukka Teilas

## _Johdanto_

TicketGuru on lipunmyyntijärjestelmä, jonka tilaajana toimii lipputoimisto. Järjestelmä mahdollistaa lipunmyynnin myyntipisteessä, jossa lipppupisteen myyjä voi myydä ja tulostaa liput asiakkaille. Järjestelmän avulla toimisto voi määritellä myytävät tapahtumat ja hallita sekä seurata lippujen myyntiä. Alustavasti järjestelmä tarjoaa lippujen myynnin myyntipisteessä, ja ennakkomyynnin päättyessä loput liput tulostetaan myytäväksi ovella. Tulostettavassa lipussa on skannattava tarkastuskoodi, joka helpottaa lippujen tarkastusta ovella.

_Asiakas_ on lipputoimisto, ja järjestelmän tarkoitus on vastata heidän tarpeisiinsa lipunmyynnissä ja tapahtumien hallinnassa. Jatkokehityksen suunnitelmissa on verkkokauppa, josta lipputoimiston asiakkaat voivat itse ostaa lippuja.

Järjestelmän palvelinpuolen toiminnot toteutetaan Javalla Spring Boot -kehystä käyttäen. Tämä valinta mahdollistaa tehokkaan ja joustavan palvelimen toiminnallisuuden rakentamisen, joka tukee tarvittavia REST-palveluita ja tietokantatoiminnallisuuksia. Tietokantana käytetään MariaDb:tä.

Käyttöliittymä on selainpohjainen React-sovellus, joka tarjoaa nykyaikaisen ja responsiivisen käyttökokemuksen.

## _Järjestelmän määrittely_

_Määrittelyssä järjestelmää tarkastellaan käyttäjän näkökulmasta. Järjestelmän
toiminnot hahmotellaan käyttötapausten tai käyttäjätarinoiden kautta, ja kuvataan järjestelmän
käyttäjäryhmät._

### Käyttäjäryhmät

_- Lyhyt kuvaus käyttäjäryhmistä (rooleista)_

- Lippupisteen myyjä

  - Fyysisessä lipunmyyntipisteessä työskentelevä henkilö, joka käyttää lipunmyyntijärjestelmän myyntipuolta etäyhteydellä erillisen päätelaitteen avulla.

- Tapahtumien hallinnoija/"toimisto"

  - Yrityksen sisäinen, toimistolla tai etänä työskentelevä käyttäjä, joka pystyy luomaan lipunmyyntijärjestelmään uusia tapahtumia ja määrittelemään niiden tiedot.

- Järjestelmän ylläpitäjä
  - Yrityksen sisäinen tai ulkopuolinen henkilö, joka ylläpitää järjestelmän toimivuutta ja mahdollisesti päivittää sitä.

**Tämä rooli on luotu jatkokehitystä ajatellen, jos/kun järjestelmään lisätään verkkokauppa.**

- **Verkkokauppa asiakas**
  - **Yrityksen ulkopuolinen henkilö, joka haluaa ostaa lipun tai lippuja yhteen tai useampaan tapahtumaan verkkokaupan kautta.**

**Tämä rooli on luotu jatkokehitystä ajatellen, jos/kun järjestelmään lisätään verkkokauppa.**

### _Käyttötapauskaavio_

- _Käyttäjäroolit ja roolien tarvitsemat toiminnot, esim. käyttötapauskaaviona
  (use case diagram) tai käyttäjätarinoina._

![Käyttötapauskaavio](/Dokumentit/Kaaviot//käyttötapauskaavio.png "Käyttötapauskaavio")

### _Käyttötapauskuvaukset_

- _Lyhyt kuvaus käyttötapauksista tai käyttäjätarinat_

### _Käyttäjätarinat_

_Kuvauksissa kannattaa harkita, mikä on toteuttajalle ja asiakkaalle oleellista
tietoa ja keskittyä siihen._

- Tapahtumien hallinnoijana haluan pystyä määrittelemään eri käyttäjäryhmille eri hintaisia lippuja, jotta voimme kohdentaa markkinointia
- Järjestelmän tilaajana haluan pystyä luomaan myymättä jääneet liput, jotta ne voidaan myydä tapahtumapaikan ovella
- Markkinointijohtajana haluan pystyä tulostamaan myyntiraportteja, jotta voin käyttää tätä dataa tulevien tapahtumien suunnitteluun
- Järjestelmän tilaajana haluan pystyä luomaan ja muokkaamaan tapahtumia
- Järjestelmän tilaajana haluan pystyä myymään lippuja järjestämiini tapahtumiin
- Järjestelmän tilaajana haluan voida perustaa uusia käyttäjiä, jotta uudet työntekijät pääsevät käyttämään järjestelmää
- Järjestelmän tilaajana haluan voida muokata käyttäjän tietoja, jotta työntekijöiden tiedot pysyvät ajantasalla
- Järjestelmän tilaajana haluan voida poistaa käyttäjiä, jotta tietoturva säilyy työsuhteiden päätyttyä



## _Käyttöliittymä_

![Käyttöliittymäkaavio](/Dokumentit/Kaaviot/käyttöliittymäkaavio.png "käyttöliittymäkaavio")

Ylläolevassa kaaviossa on kuvattu lipunmyyntijärjestelmän navigointi. Itse navipalkki vielä tästä versiosta puuttuu kokonaan. Se tullaa lisäämään projektin edetessä. Kaaviosta löytyvien kuvien perusteella kaikille applikaation sivuille on pääsy paitsi lippujen myynti sivuille. Tämä hoidettaisiin juurikin edellä mainitulla yläpalkilla.

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
