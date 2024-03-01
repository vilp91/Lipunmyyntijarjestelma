package ohjelmistoprojekti1.a3004.web;

public class KayttajaDTO {

    private String etunimi;
    private String sukunimi;
    private RooliDTO rooli;
    private String puhnro;
    private String katuosoite;
    public String getEtunimi() {
        return etunimi;
    }
    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }
    public String getSukunimi() {
        return sukunimi;
    }
    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }
    public RooliDTO getRooli() {
        return rooli;
    }
    public void setRooli(RooliDTO rooli) {
        this.rooli = rooli;
    }
    public String getPuhnro() {
        return puhnro;
    }
    public void setPuhnro(String puhnro) {
        this.puhnro = puhnro;
    }
    public String getKatuosoite() {
        return katuosoite;
    }
    public void setKatuosoite(String katuosoite) {
        this.katuosoite = katuosoite;
    }

    

}
