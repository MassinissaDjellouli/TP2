package Models.Documents;

import Models.Enums.Genres;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Livre")
public class Livre extends Documents{
    private int nbPages;
    private Genres genre;
}
