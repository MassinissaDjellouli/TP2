package Service;

import Database.BiblioDAO;
import Models.Dette;
import Models.Users.Client;

import java.time.LocalDateTime;
import java.util.Set;

public class ClientService {
    private BiblioDAO DBClient;

    public ClientService(BiblioDAO DBClient) {
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
    public void addDetteToClient(int id, float montant){
        Dette dette = Dette.builder()
                .montant(montant)
                .dateDebut(LocalDateTime.now())
                .build();
        try {
            Client client = DBClient.findClientById(id);
            client.setDette(dette);
            dette.setClient(client);
            DBClient.merge(client);
        }catch (IllegalArgumentException e){
            System.out.println("Client non existant");
        }
    }
    public Client getClientById(int id){
        return DBClient.findClientByIdWEmprunts(id);
    }
    public Set<Client> getAllClients(){
        return DBClient.findAllClient();
    }
    public Set<Client> getAllClientsWEmprunt(){
        return DBClient.findAllClientWEmprunts();
    }
}
