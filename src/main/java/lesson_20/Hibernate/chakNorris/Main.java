package lesson_20.Hibernate.chakNorris;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        //AddEmployee.addEmployee();
        GetEmployeeID.getEmployeeId(41);
        GetEmployeeOther.getEmployeeOther();
        ChangeObjectInDB.changeObjectInDB();
        DeleteFromDB.deleteFromDB();
    }
}
