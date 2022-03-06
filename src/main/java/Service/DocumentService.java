package Service;

import Database.JDBCLivres;
import Database.JDBCMedia;
import Models.Documents.Livre;
import Models.Documents.Media;

public class DocumentService {
    private JDBCLivres DBLivres;
    private JDBCMedia DBMedia;

    public DocumentService(JDBCLivres DBLivres, JDBCMedia DBMedia) {
        this.DBLivres = DBLivres;
        this.DBMedia = DBMedia;
    }
    public void saveLivre(Livre livre){

    }
    public void saveMedia(Media media){

    }
    public Livre getLivre(int id){
        return null;
    }
    public Media getMedia(int id){
        return null;
    }
}
