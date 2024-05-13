# Lipunmyyntijärjestelmä projektidokumentaatio

Tiimi: Satu Kulta, Ville Pajukangas, Ali Romar, Tuukka Teilas

## Johdanto

Asiakasyrityksenä toiminut lipputoimisto on tilannut lipunmyyntijärjestelmän backend toteutuksen sekä MVP esimerkki toteutukset lipunmyyntiä ja lipuntarkastusta toteuttavista front end clienteista. Tilattu järjestelmä mahdollistaa lipunmyynnin myyntipisteessä, jossa lippupisteen myyjä voi myydä ja tulostaa liput asiakkaille. Järjestelmän avulla toimisto/tapahtumia hallinnoiva taho voi määritellä myytävät tapahtumat aikoineen, paikkoineen sekä lipputyyppineen ja hallita sekä seurata lippujen myyntiä. Järjestelmä mahdollistaa myös ennakkomyynnin päättyessä loppujen lippujen tulostamisen myytäväksi ovella. Tulostettavassa lipussa on yksilöllinen tarkastuskoodi. Tämä koodi voidaan muuttaa esimerkiksi QR-koodiksi, joka helpottaa lippujen tarkastusta ovella. 

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


## Tietokanta


![Tietokantakaavio](/Dokumentit/Kaaviot/tietokantakaavio.png "tietokantakaavio")  
Yllä oleva kuva sisältää toteutetun tietokannan relaatiokaavion. Taulujen välisiä suhteita kuvaamaan on käytetty Crow's foot notaatioita.

> ### Tapahtuma
>
> Tapahtuma-taulu sisältää tapahtumat ja niiden tiedot kuten nimen, sijainnin ja ajan sekä saatavilla olevien lippujen kokonaismäärän ja myytyjen lippujen määrän.  
Tapahtuma-taulu ei sisällä tapahtuman yksittäisiä lippuja tai niiden tietoja vaan nämä ovat erillisissä tauluissaan.  
Tapahtumalle generoidaan sitä luotaessa uniikki tapahtumaId automaattisesti.  
Tapahtumaa luotaessa pakollisia tietoja ovat tapahtumanNimi, paikka, katuosoite, alku sekä lippuLukum.
>
> | Kenttä          | Tyyppi       | Kuvaus                                   |
> | --------------- | ------------ | ---------------------------------------- |
> | tapahtumaId    | int PK       | tapahtuman id                            |
> | tapahtumanNimi | varchar(100) | tapahtuman nimi                          |
> | paikka          | varchar(100) | tapahtumapaikka                          |
> | katuosoite      | varchar(100) | tapahtumapaikan katuosoite               |
> | alku            | date         | tapahtuman alkuaika                      |
> | loppu           | date         | tapahtuman loppuaika                     |
> | lippuLukum       | int          | tapahtumaan myytävien lippujen lukumäärä |
> | myydytLippuLukum | int          | tapahtumaan jo myytyjen lippujen lukumäärä |
> | poistettu       | boolean          | määrittää onko tapahtuma aktiivinen |

> ### TapahtumanLipputyyppi
>
> TapahtumanLipputyyppi-taulu sisältää tapahtumiin määritetyt lipputyypit. Tapahtuman lipputyyppi voi olla useassa lipussa. Sillä on aina yksi lipputyyppi ja se kuuluu yhteen tapahtumaan.  
TapahtumanLipputyyppille generoidaan sitä luotaessa uniikki tapahtumanLipputyyppiId automaattisesti.  
TapahtumanLipputyyppiä luotaessa pakollisia tietoja ovat tapahtumaId, lipputyyppiId ja hinta.


> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> tapahtumanLipputyyppiId | int PK | tapahtuman lipputyypin id
> tapahtumaId | int FK | tapahtuma, johon lipputyyppi liittyy, viittaus [tapahtuma](#tapahtuma)-tauluun
> lipputyyppiId | int FK | viittaus [lipputyyppi](#lipputyyppi)-tauluun, joka sisältää lipputyypin nimen/kuvauksen esim. lastenlippu, eläkeläislippu..
> hinta | float | lipputyypin hinta
> poistettu | boolean | määrittää onko tapahtumanLipputyyppi aktiivinen


> ### Lippu
>
> Lippu-taulu sisältää tapahtumiin luodut liput. Yksittäinen lippu voidaan luoda joko myyntitapahtuman kautta tai hyödyntämällä loppujen lippujen tulostusta, joka ei liitä lippuja mihinkään myyntitapahtumaan.  
Lipulle generoidaan sitä luotaessa uniikki lippuId sekä uniikki lippunumero automaattisesti.
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> lippuId | int PK | lipun id
> tapahtumanLipputyyppiId | int FK | lipun tapahtumakohtainen tyyppi, viittaus [tapahtumanLipputyyppi](#tapahtumanLipputyyppi)-tauluun
> myyntitapahtumaId | int FK | myyntitapahtuma, johon lippu liittyy, viittaus [myyntitapahtuma](#myyntitapahtuma)-tauluun
> lippunumero | varchar(36) | lipun uniikki lippunumero
> hinta | float | lipun lopullinen hinta, mahdollisine alennuksineen
> kaytetty | date | päivämäärä ja aika, jolloin kyseinen lippu on merkitty käytetyksi
> poistettu | boolean | määrittää onko lippu aktiivinen

> ### Lipputyyppi
>
> Lipputyyppi-taulu sisältää lipputyyppien nimet/kuvaukset. Lipputyyppi voi olla useassa tapahtumanLipputyypissä, kunhan ne kuuluvat eri tapahtumiin.  
Lipputyypille generoidaan sitä luotaessa uniikki lipputyyppiId automaattisesti.
Lipputyyppiä luodessa pakollinen tieto on tyyppi.
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> lipputyyppiId | int PK | lipputyypin id
> tyyppi | varchar(50) | lipputyypin nimi/kuvaus esim. lastenlippu, eläkeläislippu, jne.
> poistettu | boolean | määrittää onko lipputyyppi aktiivinen


> ### Myyntitapahtuma
>
> Myyntitapahtuma-taulu sisältää lippujen myyntitapahtumat. Myyntitapahtumalla on aina yksi käyttäjä ja myyntitapahtumaan voi sisältyä useita lippuja.
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> myyntitapahtumaId | int PK |myyntitapahtuman id
> kayttajaId | int FK | myyntitapahtuman luojan (myyjän) käyttäjätieto, viittaus [käyttäjä](#kayttaja)-tauluun
> aikaleima | date | myyntitapahtuman tallennuspäivä
> poistettu | boolean | määrittää onko myyntitapahtuma aktiivinen

> ### Kayttaja
>
> Kayttaja-taulu sisältää järjestelmän käyttäjät.  
 Käyttäjälle generoidaan sitä luotaessa uniikki kayttajaId automaattisesti.  
 Käyttäjää luotaessa pakollisia tietoja ovat kayttajanimi (käytetään kirjautumiseen), salasana, etunimi ja sukunimi. Salasana syötetään salaamattomana selkotekstinä ja se salataan automaattisesti palvelinpuolella.
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> kayttajaId | int PK | käyttäjän id
> rooliId | int FK | käyttäjän rooli(t), viittaus [rooli](#rooli) -tauluun
> kayttajanimi | varchar(50) | käyttäjän käyttäjänimi
> salasana | varchar(100) | käyttäjän salasana
> etunimi | varchar(50) | käyttäjän etunimi
> sukunimi | varchar(50) | käyttäjän sukunimi
> puhnro | varchar(20) | käyttäjän puhelinnumero
> katuosoite | varchar(100) | käyttäjän katuosoite
> poistettu | boolean | määrittää onko käyttäjä aktiivinen

> ### Rooli
>
> Rooli-taulu sisältää käyttäjien roolit. Rooli voi liittyä useaan käyttäjään. Roolia hyödynnetään käyttäjien auktorisoinnissa. Roolille generoidaan sitä luotaessa uniikki rooliId automaattisesti. Roolia luotaessa pakollinen tieto on rooli.
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> rooliId | int PK | roolin id
> rooli | varchar(50) | roolin nimi/kuvaus
> poistettu | boolean | määrittää onko rooli aktiivinen

## Tekninen kuvaus

### Sovellustekniset ratkaisut

Järjestelmä on suunniteltu toimimaan kolmikerroksisessa arkkitehtuurissa:  
- Käyttöliittymätaso, jonka lopullinen versio ei sisältynyt järjestelmän tilaukseen, mutta josta on tehty referenssitoteutuksia lipunmyynnin ja -tarkistuksen osalta. Nämä pyörivät erillisella palvelimella, johon loppukäyttäjä ottaa yhteyttä selaimen tai erillisen sovelluksen välityksellä. 
- Sovellustaso eli palvelinpuolen toiminnot, jotka on toteutettu Javalla Spring Boot -kehystä hyödyntäen sekä käyttäen Mavenia riippuvuuksien hallintaan. Tämä valinta mahdollistaa tehokkaan ja joustavan palvelimen toiminnallisuuden rakentamisen, joka tukee tarvittavia REST-palveluita. Palvelinpuolen toiminnot ajetaan myös käyttöliittymätasosta itsenäisellä palvelimella.
- Datataso, joka koostuu tilatussa järjestelmässä mm. Spring Boot -kehyksen tarjoamista Spring Data JPA ja Hibernate ominaisuuksista sekä niiden kanssa keskustelevasta erillisestä tietokannasta.

Tietokantana nykyisessä tuotantoympäristössä käytetään MySQL:ää. Kehitysympäristössä on mahdollista hyödyntää joko vastaavaa pysyvää relaatiotietokantaa kuten MySQL tai ajonaikaista h2 tietokantaa.

Käyttöliittymät lipunmyynnin ja -tarkastuksen referenssitoteutuksissa on toteutettu selainpohjaisina React-sovelluksina, jotka tarjoavat nykyaikaisen ja responsiivisen käyttökokemuksen.

Alla on kolmikerroksiseen arkkitehtuuriin perustuvan järjestelmäkokonaisuuden rakennetta havainnollistava kuva.  

![LipunmyyntijärjestelmäRakennekaavio](/Dokumentit/Kaaviot/LipunmyyntijärjestelmäRakenne.drawio.png)


Kuvasta poiketen datatason repositorioluokat ajetaan käytännössä osana sovellustason toteutusta. Myös kehitysympäristössä hyödynnettävä ajonaikainen h2 tietokanta ajetaan sovellustasolla.

### Turvallisuus

Järjestelmässä hyödynnetään Spring Securityä ja Http Basic autentikointia. Http basicin salaamattoman luonteen vuoksi järjestelmää suositellaan käytettäväksi internetissä vain https protokollan kanssa. Järjestelmän palvelinpuolen konfiguroidut turvallisuusasetukset voi tarkistaa [täältä](/src/main/java/ohjelmistoprojekti1/a3004/WebSecurityConfig.java "WebSecurityConfig"). Salasanojen suojaamisessa hyödynnetään palvelinpuolella automatisoitua BCryptPasswordEncoder metodia eli kun uusi käyttäjä luodaan, tämän salasana enkoodataan. Yleisen autentikointi vaatimuksen lisäksi järjestelmässä on käytetty metodikohtaista auktorisointia PreAuthorize annotaatioilla hyödyntäen käyttäjille määriteltyjä rooleja.

### Sovellustason rajapinta

Järjestelmään on toteutettu palvelinpuolelle REST rajapinta, jolle on luotu [kattava dokumentaatio](/Dokumentit/API%20dokumentaatio/README.md "REST API dokumentaatio").  
Oheinen sekvenssikaavio havainnollistaa onnistunutta lipunmyyntitapahtumaa. Kuvan alla on tekstimuotoinen tarkenne kaaviosta.
![RajapinnanSekvenssikaavio](/Dokumentit/Kaaviot/RajapinnanSekvenssikaavio.drawio.png)

Lipunmyyntipisteen sovellus lähettää GET pyynnön palvelimen /tapahtumat endpointiin. Palvelin hakee tiedot tietokannasta ja lähettää ne takaisin käyttöliittymätasolle. 

Lipunmyyntipisteen sovellus lähettää POST pyynnön palvelimen /myyntitapahtumat endpointiin. Palvelin suorittaa omat tarkistuksensa, onko pyyntö validi ja jos se onnistuu niin palvelin luo tietokantaan uuden lipun ja lähettää lipun sekä myyntitapahtuman tiedot takaisin. 

Lipunmyyntipisteellä luotu lippu voidaan tulostaa asiakkaalle.

## Testaus

Järjestelmälle on kirjoitettu minimaalinen määrä automatisoituja [yksikkö-](/src/test/java/ohjelmistoprojekti1/a3004/RepositoryTests/LipputyyppiTests.java) sekä [integraatiotestejä](/src/test/java/ohjelmistoprojekti1/a3004/RestApiTests/RestTapahtumaTests.java). Nämä testit on tarkoitus suorittaa aina ohjelmistokoodia muutettaessa regressiotestauksen nimissä. Automaattista CI/CD pipelinen pystyttämistä sekä testauksen lisäystä suositellaan vahvasti jos ohjelmistoa aiotaan jatkokehittää. Testejä suositellaan kirjoitettavaksi lisää myös jo olemassa olevalle koodille.

Tämän hetkinen testauksemme taso on eritelty erillisessä [testi dokumentaatiossa](/Dokumentit/Testi%20dokumentaatio.md).


## Asennustiedot

Järjestelmä on tällä hetkellä saatavilla [GitHubin repositoriossa](https://github.com/vilp91/Lipunmyyntijarjestelma/ "Lipunmyyntijärjestelmän GitHub repositorio").

Järjestelmä voidaan kopioida repositoriosta paikalliseen ympäristöön [GitHubin ohjeiden](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository "GitHub - Cloning a repository") avulla.

Järjestelmässä hyödynnetään Spring Bootin profiileja, joita on luotu kaksi erillistä: [dev](/src/main/resources/application-dev.properties) ja [rahti](/src/main/resources/application-rahti.properties). Näistä profiileista dev on räätälöity käyttämään paikallisesti luotavaa tilapäistä h2 tietokantaa ja sen pitäisi olla käyttövalmis. Rahti profiili sen sijaan on kustomoitu hyödyntämään CSC:n rahti palveluumme julkaisemaa versiota sovelluksestamme sekä siellä olevaa MySql tietokantaa. Rahti profiilin on kuitenkin mahdollista toimia vaikka palvelun julkaisisi muullakin alustalla, kunhan otetaan huomioon, että profiilissa esitetyt muuttujat vastaavat kyseisen ympäristön vastaavia muuttujia.

Luotaessa uusia käyttäjiä ja näiden rooleja, tulee ottaa huomioon metodikohtaisissa auktorisoinneissa määritellyt roolien nimet; erityisesti tuotantoympäristössä.

### Järjestelmän asentaminen kehitysympäristöön

Kun järjestelmä on kopioitu paikalliseen ympäristöön, projekti voidaan avata millä tahansa sitä tukevalla IDE:llä. Hyödyntämällä dev profiilia, järjestelmä pitäisi pystyä käynnistämään. Järjestelmä luo automaattisesti [CommandLineRunner demo:ssa etukäteen määritellyn demodatan](/src/main/java/ohjelmistoprojekti1/a3004/A3004Application.java) perusteella ajonaikaisen h2 tietokannan, jota voi halutessaan muokata tarvitsemakseen.

### Järjestelmän asentaminen tuotantoympäristöön

Järjestelmää asennettaessa tuotantoympäristöön oletetaan, että käyttöön halutaan pysyvä tietokanta.
Järjestelmä voidaan asentaa haluamaansa tuotantoympäristöön kunhan otetaan huomioon, että pysyvän tietokannan luomisessa noudatetaan toimitetussa [dokumentaatiossa määriteltyä tietokannan rakennetta](/Dokumentit/Kaaviot/tietokantakaavio.png "Tietokantakaavio"). Järjestelmä on suunniteltu toimimaan SQL tietokannoilla ja sen toiminta on varmistettu vain MySql:llä.
Spring Boot voi luoda automaattisesti tietokannalle skeeman hyödyntäen esimerkiksi Hibernaten Auto DDL toiminnallisuutta. Tämä pitää erikseen määrittää profiilien asetuksissa (= spring.jpa.hibernate.ddl-auto=create). Myös muita vaihtoehtoja on tarjolla: [ulkoinen dokumentaatio aiheesta](https://docs.spring.io/spring-boot/docs/1.1.0.M1/reference/html/howto-database-initialization.html "Spring Boot dokumentaatio - Database initialization; Avaa sivun selaimeen").

## Käynnistys- ja käyttöohje

Tällä hetkellä järjestelmän live versio pyörii CSC:n rahti palvelussa, jonka osoitteen runko on http://lipunmyyntijarjestelma-ohjelmistoprojekti-1.rahtiapp.fi .
Tätä URL runkoa käyttämällä pääsee hyödyntämään luomaamme REST rajapintaa, johon löytyy ohjeistus [täältä](/Dokumentit/API%20dokumentaatio/README.md "Rest API Dokumentaatio").

Referenssitoteutuksemme lipunmyynnistä ja -tarkastuksesta pyörivät tällä hetkellä GitHub Pages palvelussa [täällä](https://vilp91.github.io/Lipunmyyntijarjestelma/ "Lipunmyynti ja lipuntarkastus referenssitoteutukset")

Palveluihin tarvittavat tunnukset toimitetaan erikseen sovittavalla tavalla.