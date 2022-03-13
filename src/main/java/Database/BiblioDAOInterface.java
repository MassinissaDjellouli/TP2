package Database;

import Models.Documents.Documents;
import Models.Users.Client;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public interface BiblioDAOInterface {
     <T> void save(T tosave);
     <T> void delete(T toDelete);
     <T> void merge(T toMerge);
     Documents findDocumentById(int id);
     Set<Documents> findAllDocuments();
     Client findClientById(int id);
     Client findClientByIdWEmprunts(int id);
     Set<Client> findAllClient();
     Set<Client> findAllClientWEmprunts();
}
