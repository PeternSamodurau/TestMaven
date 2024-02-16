package lesson_20.Hibernate.chakNorris;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.stream.Collectors;

public class GetEmployeeOther {
    public static void getEmployeeOther() {

        SessionFactory factory = new Configuration()
                .configure("hibernateChakNorris.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {

            Session session = factory.getCurrentSession();

            session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Employee> query = builder.createQuery(Employee.class);

            Root<Employee> root = query.from(Employee.class);

            query.select(root);

            List<Employee> employeeList = session.createQuery(query).getResultList();
            employeeList.stream().forEach(System.out::println);

            System.out.println("_________________________________________________");

            employeeList.stream()
                    .filter(employee -> employee.getName().equals("katerina") && employee.getSalary() == 500);


           employeeList.forEach(System.out::println);


            session.getTransaction().commit();


        } finally {
            factory.close();
        }
    }
}
