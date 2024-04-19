package lesson_20.Hibernate.skillbox.hibernate_query_builder;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lesson_20.Hibernate.skillbox.HibernateUtil;
import lesson_20.Hibernate.skillbox.entity.Course;
import org.hibernate.Session;

import java.util.List;

public class HQL {
    public static void hibernateQueryBuilder(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);

        query.select(root);

        List<Course> courseList = session.createQuery(query).getResultList();
       for (Course course: courseList){
           System.out.println(course.getName() + " - " + course.getTeacher().getName());
       }

        session.close();

    }
}
