import Database.JDBCLivres;
import Models.Documents.Enums.Genres;
import Models.Documents.Livre;

public class Main {
    public static void main(String[] args) {
        JDBCLivres livres = new JDBCLivres();
        livres.createTable();
        Livre desSourEtDesHom = new Livre("Des souris et des hommes","John Steinback","Alto", 1937,224, Genres.roman);
        livres.save(desSourEtDesHom);
        Livre livre = livres.get(1);
        System.out.println(livre);
    }
}
