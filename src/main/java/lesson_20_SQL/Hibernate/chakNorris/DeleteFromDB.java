package lesson_20_SQL.Hibernate.chakNorris;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteFromDB {
    public static void deleteFromDB() {
        SessionFactory factory = new Configuration()
                .configure("hibernateChakNorris.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 18);
           // session.delete(employee);                                // УДАЛЯЕМ работника с id =18
            System.out.println("____________________________________");
            System.out.println("удалим работников с именим Peter");

            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Employee> query = builder.createQuery(Employee.class);

            Root<Employee> root = query.from(Employee.class);

            query.select(root);

            List<Employee> employeeList = session.createQuery(query).getResultList();
            employeeList.stream()
                    .filter(employee1 -> employee1.getName().equals("Peter"))
                    .forEach(employee1 -> {
                       session.remove(employee1);
                    });

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}

