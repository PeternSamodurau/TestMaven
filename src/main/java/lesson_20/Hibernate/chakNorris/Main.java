package lesson_20.Hibernate.chakNorris;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Cоздадим SessionFactory - фвбрика по производству сессий");
        SessionFactory factory = new Configuration()
                .configure("hibernateChakNorris.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {

            System.out.println("Cоздадим сессию - обертка вокруг подключения к базе данных с помощью JDBC");
            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Peter", "Samadurau", "IT", 500);  // id не пишем он генерируется базой данных

            System.out.println("создаем транзакцию");
            session.beginTransaction();
            System.out.println("сохраняем объект");
            session.save(employee);
            System.out.println("закрываем транзакцию через commit");
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
