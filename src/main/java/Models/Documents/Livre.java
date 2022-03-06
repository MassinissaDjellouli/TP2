package Models.Documents;

import Models.Documents.Enums.Genres;

public class Livre extends Documents{
    private final int nbPages;
    private final Genres genre;


    public Livre(String titre, String auteur, String editeur, int anneeDePublication, int nbPages, Genres genre) {
        super(titre, auteur, editeur, anneeDePublication, 3);
        this.genre = genre;
        this.nbPages = nbPages;
    }

    public int getNbPages() {
        return nbPages;
    }

    public Genres getGenre() {
        return genre;
    }
}
