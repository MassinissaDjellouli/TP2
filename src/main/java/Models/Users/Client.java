package Models.Users;

import Models.Documents.Documents;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    private int clientNumber;
    private String clientName;
    private String clientAdress;
    private String clientPhone;
    private float dette;

    private List<Documents> emprunts;


}
