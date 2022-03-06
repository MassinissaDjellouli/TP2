package Models.Documents;

import Models.Documents.Enums.MediaType;

public abstract class Documents {
    private final String titre;
    private final String auteur;
    private final String editeur;
    private final int anneeDePublication;
    private int tempsEmprunt;

    public Documents(String titre, String auteur, String editeur, int anneeDePublication, int tempsEmprunt) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.anneeDePublication = anneeDePublication;
        this.tempsEmprunt = tempsEmprunt;
    }
    public Documents(String titre, String auteur, String editeur, int anneeDePublication) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.anneeDePublication = anneeDePublication;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public int getAnneeDePublication() {
        return anneeDePublication;
    }

    public int getTempsEmprunt() {
        return tempsEmprunt;
    }

    protected void setMediaTempsEmprunts(MediaType type) {
        switch (type){
            case cd ->tempsEmprunt = 2;
            case dvd -> tempsEmprunt = 1;
        }
    }
}


