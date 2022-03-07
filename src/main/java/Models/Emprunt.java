package Models;

import Models.Documents.Documents;
import Models.Users.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emprunt {
    @Id
    private int id;
    @ManyToOne
    private Client client;
    private LocalDateTime dateTime;
    @OneToOne
    private Documents document;
    private LocalDateTime returnDateTime;
}