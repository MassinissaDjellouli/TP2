package Service;

import Database.JDBCClient;
import Models.Users.Client;

public class ClientService {
    private JDBCClient DBClient;

    public ClientService(JDBCClient DBClient) {
        this.DBClient = DBClient;
    }
    public void saveClient(Client client){

    }
    public Client getClient(int id){
        return null;
    }
}
