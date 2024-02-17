package lesson_20.Hibernate.skillbox.hql;

import lesson_20.Hibernate.skillbox.HibernateUtil;
import lesson_20.Hibernate.skillbox.entity.Course;
import org.hibernate.Session;

import java.util.List;

public class HQL {
    public static void hibernateQueryLanguage() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql = "From " + Course.class.getSimpleName() + " Where price > 120000";
        // ОЧЕНЬ ВАЖНО ПОСЛЕ FROM ПРОБЕЛ, ПЕРЕД WHERE ПРОБЕЛ
        List<Course> courseList = session.createQuery(hql).getResultList();

        System.out.println(courseList.size());

        for (Course course: courseList){
            System.out.println(course.getName() + " - " + course.getPrice());
        }

        session.close();

    }
}
