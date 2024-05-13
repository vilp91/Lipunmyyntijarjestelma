# Testauksen tasot

## Yleistä testaamisesta

Tällä hetkellä projektin testauspuoli on melko vajavaista. Tässä dokumentissa esitellään yleistä tietoutta projektissa käytetyistä testimetodeista sekä eritellään joitain toteutettuja testejä.

## Yksikkötestit
Teimme automatisoituja JUnit yksikkötestejä, joilla testasimme repositorioidemme CRUD toiminnallisuutta. Yksikkötestin tarkoituksena on testata vain yhtä kokonaisuuden osaa kerrallaan ilman riippuvaisuuksia muista ohjelmiston osista.

Tietystä näkökulmasta näitä voisi pitää integraatiotesteinä, sillä käytännössä ne testaavat myös Hibernaten ja Database access layerin toimivuutta. Tosin nämä ovat melko hyvin sisäänrakennettuja osia Spring Boot kehyksessä, joten niille omien testien kirjoittaminen tuntuu melko turhalta.

## Integraatiotestit

Tekemämme integraatiotestit toteutettiin automatisoituina Spring Boot testiluokkina, joilla voidaan testata REST API:n yhteen pelaamista Spring Securityn ja muiden ohjelmistomme osien kanssa.

Integraatiotestit eroavat yksikkötesteistä nimenomaan siksi, koska niissä testataan useamman ohjelmiston osan toimimista yhdessä. Ne eivät ole kuitenkaan yhtä kattavia kuin koko ohjelmiston kattavat E2E testit.

## E2E testit

E2E eli end-to-end testeillä testataan koko ohjelmiston toimivuutta alusta loppuun ns. oikeassa tilanteessa. Teimme E2E-testejä testailemalla järjestelmää käyttöliittymän kautta, kuten oikeassa tilanteessa.

Lipun tarkastaminen GateGuardissa onnistuu. Lippu merkataan käytetyksi ja sen uudelleen syöttäminen järjestelmään näyttää että lippu on jo käytetty.

Jos oikeasti olemassa olevasta lippunumerosta ottaa muutaman merkin pois antaa error 404, jos syötekenttään kirjoittelee omiaan tulee error 500.

Yksi uuden lipun ostaminen onnistuu. Myös useamman eri lipputyypin ostaminen onnistuu. Useamman lipun ostaminen samaan aikaan useaan eri tapahtumaan onnistuu myös.

Lippujen tapahtumaan ostaminen johon ei ole saatavilla lippuja haluttu määrä antaa ilmoituksen: Virhe - Eli virhe koodia ei jostain syystä haeta tähän.

Mahdollisia ongelmia:

- Tyhjän myyntitapahtuman luominen mahdollista.
- Postmanissa ongelmia luoda uusi tapahtuma. Tulee error 400.
- Lippujen tapahtumaan ostaminen johon ei ole saatavilla lippuja haluttu määrä antaa ilmoituksen: Virhe - Eli virhe koodia ei jostain syystä haeta tähän.
