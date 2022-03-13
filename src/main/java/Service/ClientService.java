package Service;

import Database.DAOClient;
import Models.Dette;
import Models.Users.Client;

import java.time.LocalDateTime;

public class ClientService {
    private DAOClient DBClient;

    public ClientService(DAOClient DBClient) {
        this.DBClient = DBClient;
    }
    public void saveNewClient(String name,String adress, String phone){
        Dette dette = new Dette();
        Client toSave = Client.builder()
                        .clientName(name)
                        .clientPhone(phone)
                        .clientAdress(adress)
                        .build();
        dette.setClient(toSave);
        toSave.setDette(dette);
        DBClient.save(toSave);
    }
    public void addDetteToClient(Client client, float montant){
        Dette dette = Dette.builder()
                .montant(montant)
                .dateDebut(LocalDateTime.now())
                .build();
        try {
            DBClient.findById(client.getClientNumber());
        }catch (IllegalArgumentException e){
            System.out.println("Client non existant");
        }
        DBClient.merge(client);
    }
    public Client getClient(int id){
        return null;
    }
}
