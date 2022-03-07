package Models.Documents;

import Models.Enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Documents {
    @Id
    private int documentId;
    private String titre;
    private String auteur;
    private String editeur;
    private int anneeDePublication;
    private int tempsEmprunt;

    protected static void setMediaTempsEmprunts(Media media) {
        switch (media.getType()){
            case cd -> media.setTempsEmprunt(2);
            case dvd -> media.setTempsEmprunt(1);
        }
    }
}


