package Models.Documents;

import Models.Enums.MediaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DiscriminatorValue("Media")
public class Media extends Documents{

    private String duree;
    private MediaType type;

}
