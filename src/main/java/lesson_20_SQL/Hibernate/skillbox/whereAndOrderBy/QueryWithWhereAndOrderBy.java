package lesson_20_SQL.Hibernate.skillbox.whereAndOrderBy;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lesson_20_SQL.Hibernate.skillbox.HibernateUtil;
import lesson_20_SQL.Hibernate.skillbox.entity.Course;
import org.hibernate.Session;

import java.util.List;

public class QueryWithWhereAndOrderBy {

    public static void queryWithWhereAndOrderBy(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);

        query.select(root)
                .where(builder.greaterThan(root.get("price"), 100000))
                .orderBy(builder.desc(root.get("price")));
        //стоимость курса больше чем 100000, и отсортировали по убыванию

        List<Course> courseList = session.createQuery(query).setMaxResults(5).getResultList();     //вывести только 5 парвых
        for (Course course: courseList){
            System.out.println(course.getName() + " - " + course.getPrice());
        }

        session.close();

    }
}
