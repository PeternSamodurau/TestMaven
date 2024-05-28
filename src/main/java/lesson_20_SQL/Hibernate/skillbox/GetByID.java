package lesson_20_SQL.Hibernate.skillbox;

import lesson_20_SQL.Hibernate.skillbox.entity.Course;
import lesson_20_SQL.Hibernate.skillbox.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GetByID {
    public static void getByID(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, 2);     // первый из таблици

        System.out.println(course);
        System.out.println(course.getTeacher());
        System.out.println(course.getTeacher().getName());

        System.out.println(course.getStudentList().size());
        List<Student> studentList = course.getStudentList();
        studentList.forEach(System.out::println);

        transaction.commit();
        session.close();

    }
}
