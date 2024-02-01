package lesson_20.Hibernate.skillbox;

//ORM - системы нужны чтобы легко, преобразовывать забиси из баз данных в объекты

//ORM расшифровывается как Object-Relational Mapping, что на русском означает "объектно-реляционное отображение".
// Это технология, которая “соединяет” программные сущности и соответствующие записи в базе данных.
//
//Hibernate - это фреймворк для языка Java, предназначенный для работы с базами данных.
// Он реализует объектно-реляционную модель и часто используется как ORM-провайдер в обычных Java-приложениях.
// Hibernate построен на спецификации JPA  - наборе правил, который описывает взаимодействие программных объектов с записями в базах данных.


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/skillbox?serverTimezone=UTC";
//        String user = "root";
//        String pass = "Jiffbuh1";
//
//        try {
//            Connection connection = DriverManager.getConnection(url, user, pass);
//
//            Statement statement = connection.createStatement();
//
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses");
//
//            while (resultSet.next()) {
//
//                Course course = new Course();
//                course.setId(resultSet.getInt("id"));           // ПРОПИСЫВАЕМ ВСЕ ПОЛЯ, ЧТО ОЧЕНЬ НЕ УДОБНО
//                course.setName(resultSet.getString("name"));    // и тд все поля объекта Course
//                //.....
//
//                String courseName = resultSet.getString("name");
//                System.out.println(courseName);
//            }
//            resultSet.close();
//            statement.close();
//            connection.close();
//
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

        StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Course course = session.get(Course.class, 1);
        System.out.println(course.getName());

        sessionFactory.close();

    }
}
