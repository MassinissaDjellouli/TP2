package Models.Documents;

import Models.Enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int documentId;
    private String titre;
    private String auteur;
    private String editeur;
    private int anneeDePublication;
    private int tempsEmprunt;
    private int nbExemplaires;

    protected static void setMediaTempsEmprunts(Media media) {
        switch (media.getType()){
            case cd -> media.setTempsEmprunt(2);
            case dvd -> media.setTempsEmprunt(1);
        }
    }
}


