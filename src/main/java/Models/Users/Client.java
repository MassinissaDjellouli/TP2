package Models.Users;

import Models.Dette;
import Models.Documents.Documents;
import Models.Emprunt;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clientNumber;
    private String clientName;
    private String clientAdress;
    private String clientPhone;
    @OneToOne
    @ToString.Exclude
    private Dette dette;
    @ToString.Exclude
    @OneToMany(mappedBy = "client",cascade = CascadeType.PERSIST)
    private List<Emprunt> emprunts;


}
