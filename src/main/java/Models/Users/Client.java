package Models.Users;

import Models.Documents.Documents;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final int clientNumber;
    private final String clientName;
    private String clientAdress;
    private String clientPhone;
    private float dette;
    private List<Documents> emprunts;

    public Client(int clientNumber, String clientName, String clientAdress, String clientPhone, int dette) {
        this.clientNumber = clientNumber;
        this.clientName = clientName;
        this.clientAdress = clientAdress;
        this.clientPhone = clientPhone;
        this.dette = dette;
        this.emprunts = new ArrayList<>();
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAdress() {
        return clientAdress;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public float getDette() {
        return dette;
    }

    public List<Documents> getEmprunts() {
        return emprunts;
    }
}
