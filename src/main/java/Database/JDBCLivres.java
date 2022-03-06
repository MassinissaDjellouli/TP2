package Database;

import Models.Documents.Enums.Genres;
import Models.Documents.Livre;

import java.sql.*;

public class JDBCLivres implements JDBCInterface<Livre> {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/TP";
    private static final String USER = "sa";
    private static final String PASS = "";

    private Connection connection;
    private PreparedStatement prepStatement;

    @Override
    public void handleException(Exception e) {
        System.out.println("Une erreur est survenue: \n" + e.getLocalizedMessage() + "\n");
    }

    @Override
    public void save(Livre toSave) {
        try {
            setConnection();
            insert(toSave);
            connection.commit();
        }catch (Exception e){
            handleException(e);
        }finally {
            close();
        }
    }

    @Override
    public void createTable() {
        try {
            setConnection();
            create();
        } catch(Exception e) {
            handleException(e);
        }finally {
            close();
        }
    }

    @Override
    public Livre get(int id) {
        try {
            setConnection();
            Livre livre = resultSetToLivre(select(id));
            connection.commit();
            return livre;
        }catch (Exception e){
            handleException(e);
        }finally {
            close();
        }

        return null;
    }


    private void close(){
        try{
            if(prepStatement!=null)
                prepStatement.close();
        } catch(SQLException e) {}
        try {
            if(connection!=null)
                connection.rollback();
                connection.close();
        } catch(SQLException e){
            handleException(e);
        }
    }

    private void setConnection() throws SQLException {
        connection = DriverManager.getConnection(DB_URL,USER,PASS);
    }

    private void create() throws SQLException{
        String statement = "CREATE TABLE LIVRES(" +
                "id NUMBER PRIMARY KEY," +
                "titre CHAR(140)," +
                "auteur CHAR(50)," +
                "editeur CHAR(50)," +
                "anneeDePublication NUMBER," +
                "nbPages NUMBER," +
           "genre CHAR(10)" +
                    "CONSTRAINT checkGenre CHECK ( trim(genre) = '" + Genres.roman + "' " +
                            "OR trim(genre)  = '" + Genres.etude + "' " +
                            "OR trim(genre)  = '" + Genres.magazine + "' " +
                            "OR trim(genre)  = '" + Genres.manuel + "' " +
                    ")" +
                ")";
        prepStatement = connection.prepareStatement(statement);
        prepStatement.execute();
    }
    private int generateID(){
        try{
            ResultSet resultSet = selectCount();
            resultSet.next();
            int size = resultSet.getInt("count");
            resultSet = selectAll();
            while (size > 0){
                size--;
                resultSet.next();
            }
            return resultSet.getInt("id") + 1;
        }catch (Exception e){
            return 1;
        }
    }
    private void insert(Livre livre) throws SQLException {
        String statement = "INSERT INTO LIVRES VALUES (" +
                 generateID() + ",'" +
                 livre.getTitre() + "','" +
                 livre.getAuteur() + "','" +
                 livre.getEditeur() + "'," +
                 livre.getAnneeDePublication() + "," +
                 livre.getNbPages() + ",'" +
                 livre.getGenre() +
                "')";
        prepStatement = connection.prepareStatement(statement);
        prepStatement.execute();
    }
    private ResultSet select(int id) throws SQLException {
        String statement = "SELECT * FROM LIVRES WHERE id = " + id;
        prepStatement = connection.prepareStatement(statement);
        return prepStatement.executeQuery();
    }
    private ResultSet selectCount() throws SQLException {
        String statement = "SELECT COUNT(*) AS count FROM LIVRES";
        prepStatement = connection.prepareStatement(statement);
        return prepStatement.executeQuery();
    }
    private ResultSet selectAll() throws SQLException {
        String statement = "SELECT * FROM LIVRES";
        prepStatement = connection.prepareStatement(statement);
        return prepStatement.executeQuery();
    }

    private Livre resultSetToLivre(ResultSet resultSet) throws SQLException {
        resultSet.next();
        return  new Livre(
                            resultSet.getString("titre").trim(),
                            resultSet.getString("auteur").trim(),
                            resultSet.getString("editeur").trim(),
                            resultSet.getInt("anneeDePublication"),
                            resultSet.getInt("nbPages"),
                            Genres.stringToGenres(resultSet.getString("genre").trim())
                            );
    }
}
