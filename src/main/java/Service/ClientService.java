package Service;

import Database.DAOClient;
import Models.Users.Client;

public class ClientService {
    private DAOClient DBClient;

    public ClientService(DAOClient DBClient) {
        this.DBClient = DBClient;
    }
    public void saveClient(Client client){

    }
    public Client getClient(int id){
        return null;
    }
}
