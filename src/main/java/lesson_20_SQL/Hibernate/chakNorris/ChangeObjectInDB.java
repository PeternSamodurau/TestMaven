package lesson_20_SQL.Hibernate.chakNorris;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ChangeObjectInDB {

    public static void changeObjectInDB() {

        SessionFactory factory = new Configuration()
                .configure("hibernateChakNorris.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 46);
            employee.setSalary(1500);                                  // меняем з/п у работника с id 46
            System.out.println("________________________________________");
            System.out.println("Mеняем з/п у работника с id 46");
            GetEmployeeID.getEmployeeId(46);

            System.out.println("_________________________________________");
            System.out.println("поменяем з/п у всех работников с именим Peter");

            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Employee> query = builder.createQuery(Employee.class);

            Root<Employee> root = query.from(Employee.class);

            query.select(root);

            List<Employee> employeeList = session.createQuery(query).getResultList();

             employeeList.stream()
                    .filter(employee1 -> employee1.getName().equals("Peter"))
                    .peek(employee1 -> employee1.setSalary(1000));


            employeeList.forEach(System.out::println);


            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}