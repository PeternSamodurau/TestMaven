package lesson_20_SQL.Hibernate.skillbox;

import lesson_20_SQL.Hibernate.skillbox.entity.Course;
import lesson_20_SQL.Hibernate.skillbox.entity.CourseType;
import lesson_20_SQL.Hibernate.skillbox.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddToDB {
    public static void addToDB(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Course course = new Course();
        course.setId(53);
        course.setName("New course");
        course.setType(CourseType.DESIGN);
        course.setTeacher(new Teacher());

        System.out.println(course);

        transaction.commit();
        session.close();

    }
}
