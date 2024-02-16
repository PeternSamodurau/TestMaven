package lesson_20.Hibernate.skillbox;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ChangeInDB {

    public static void changeInDB(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class,53);
        course.setName("Поменяли название курса у номера 53");

        System.out.println(course);

        transaction.commit();
        session.close();

    }
}
