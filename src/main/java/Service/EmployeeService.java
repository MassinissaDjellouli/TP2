package Service;

import Database.JDBCEmploye;
import Models.Users.Employe;

public class EmployeeService {
    private JDBCEmploye DBEmploye;

    public EmployeeService(JDBCEmploye DBEmploye) {
        this.DBEmploye = DBEmploye;
    }
    public void saveEmployee(Employe employe){

    }
    public Employe getEmploye(int id){
        return null;
    }
}
