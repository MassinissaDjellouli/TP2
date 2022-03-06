package Models.Documents;

import Models.Documents.Enums.MediaType;

public class Media extends Documents{

    private final String duree;
    private final MediaType type;


    public Media(String titre, String auteur, String editeur, int anneeDePublication, String duree, MediaType type) {
        super(titre, auteur, editeur, anneeDePublication, 3);
        this.duree = duree;
        this.type = type;
        setMediaTempsEmprunts(type);
    }

    public String getDuree() {
        return duree;
    }

    public MediaType getType() {
        return type;
    }
}
