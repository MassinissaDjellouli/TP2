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

        try {
            Client client = DB.findClientById(id);
            Dette oldDette = client.getDette();
            Dette dette = Dette.builder()
                    .montant(montant)
                    .dateDebut(LocalDateTime.now())
                    .id(oldDette.getId())
                    .build();
            client.setDette(dette);
            dette.setClient(client);
            DB.merge(dette);
            DB.merge(client);
        }catch (IllegalArgumentException e){
            DB.handleException("Une erreur est survenue avec la base de donnée");
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
