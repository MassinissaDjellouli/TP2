package Service;

import Database.BiblioDAO;
import Models.Dette;
import Models.Users.Client;

import java.time.LocalDateTime;
import java.util.Set;

public class ClientService {
    private BiblioDAO DB;

    public ClientService(BiblioDAO DBClient) {
        this.DB = DBClient;
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
        DB.save(toSave);
    }
    public void addDetteToClient(int id, float montant){
        Dette dette = Dette.builder()
                .montant(montant)
                .dateDebut(LocalDateTime.now())
                .build();
        try {
            Client client = DB.findClientById(id);
            DB.delete(client.getDette());
            client.setDette(dette);
            dette.setClient(client);
            DB.merge(client);
        }catch (IllegalArgumentException e){
            System.out.println("Client non existant");
        }
    }
    public Client getClientById(int id){
        return DB.findClientByIdWEmprunts(id);
    }
    public Set<Client> getAllClients(){
        return DB.findAllClient();
    }
    public Set<Client> getAllClientsWEmprunt(){
        return DB.findAllClientWEmprunts();
    }
}
