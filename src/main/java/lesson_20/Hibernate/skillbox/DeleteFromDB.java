package lesson_20.Hibernate.skillbox;

import lesson_20.Hibernate.skillbox.entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteFromDB {
    public static void deleteFromDB(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class,53);
        session.delete(course);

        System.out.println(course);

        transaction.commit();
        session.close();

    }
}
