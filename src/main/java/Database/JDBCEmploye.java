package Database;

import Models.Users.Employe;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCEmploye implements JDBCInterface<Employe> {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/TP";
    private static final String USER = "sa";
    private static final String PASS = "";

    private Connection connection;
    private PreparedStatement prepStatement;
    @Override
    public void save(Employe toSave) {

    }

    @Override
    public void createTable() {

    }

    @Override
    public Employe get(int id) {
        return null;
    }

    @Override
    public void handleException(Exception e) {

    }
}
