package lesson_20_SQL.Hibernate.chakNorris;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddEmployee {

    public static Integer addEmployee() {
        System.out.println("Cоздадим SessionFactory - фвбрика по производству сессий");
        SessionFactory factory = new Configuration()
                .configure("hibernateChakNorris.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            System.out.println("Cоздадим сессию - обертка вокруг подключения к базе данных с помощью JDBC");

            Session session = factory.getCurrentSession();

            Employee employee = new Employee("katerina", "Golub", "Arch", 500);  // id не пишем он генерируется базой данных

            System.out.println("создаем транзакцию");
            session.beginTransaction();
            System.out.println("сохраняем объект");
            session.save(employee);

            System.out.println("Добавляем работника - " + employee);


            System.out.println("закрываем транзакцию через commit");
            session.getTransaction().commit();

            return employee.getId();

        }finally {
            factory.close();
        }
    }
}

