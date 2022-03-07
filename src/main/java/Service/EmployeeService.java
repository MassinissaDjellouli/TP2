package Service;

import Database.DAODocuments;
import Database.DAOEmploye;
import Models.Users.Employe;

public class EmployeeService {
    private DAOEmploye DBEmploye;

    public EmployeeService(DAOEmploye DBEmploye) {
        this.DBEmploye = DBEmploye;
    }
    public void saveEmployee(Employe employe){

    }
    public Employe getEmploye(int id){
        return null;
    }
}
