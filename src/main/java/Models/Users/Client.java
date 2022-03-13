package Models.Users;

import Models.Documents.Documents;
import Models.Emprunt;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private float dette;
    @OneToMany(mappedBy = "client",cascade = CascadeType.PERSIST)
    private List<Emprunt> emprunts;


}
