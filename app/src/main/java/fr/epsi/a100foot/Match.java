package fr.epsi.a100foot;

import java.util.Date;

public class Match {

    protected String titre = "Non défini";
    protected Date datePublication  = null;

    public Match() {

    }

    public Match(String titre, Date datePublication, String link) {
        this.titre = titre;
        this.datePublication = datePublication;
    }

    public String getTitre() {
        return titre;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

}
