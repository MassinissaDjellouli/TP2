package Service;

import Database.BiblioDAO;
import Models.Users.Employe;

public class EmployeeService {
    private BiblioDAO DB;

    public EmployeeService(BiblioDAO DBEmploye) {
        this.DB = DBEmploye;
    }

}
