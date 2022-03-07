package Service;

import Database.DAODocuments;
import Models.Documents.Documents;
import Models.Documents.Livre;
import Models.Documents.Media;

public class DocumentService {
    private DAODocuments DBDocument;

    public DocumentService(DAODocuments DBDocuments) {
        this.DBDocument = DBDocuments;
    }
    public Documents getDocument(int id){
        return null;
    }
    public void saveDocument(Documents toSave){

    }
}
