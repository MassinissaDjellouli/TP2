package Database;

import Models.Documents.Documents;
import Models.Documents.Livre;
import Models.Documents.Media;
import Models.Users.Client;
import java.util.Set;

public interface BiblioDAOInterface {
     <T> void save(T tosave);
     <T> void delete(T toDelete);
     <T> void merge(T toMerge);
     Documents findDocumentById(int id);
     Set<Documents> findAllDocuments();
     Set<Livre> findAllLivre();
     Client findClientById(int id);
     Client findClientByIdWEmprunts(int id);
     Set<Client> findAllClient();
     Set<Client> findAllClientWEmprunts();
    void handleException(String msg);
     Set<Media> findAllMedia();
}
