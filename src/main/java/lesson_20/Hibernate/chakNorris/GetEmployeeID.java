package lesson_20.Hibernate.chakNorris;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetEmployeeID {

    public static void getEmployeeId(int id) {

        SessionFactory factory = new Configuration()
                .configure("hibernateChakNorris.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, id);
            System.out.println("Получаем работника - " + employee);

            session.getTransaction().commit();

        }finally {
            factory.close();
        }

    }
}
