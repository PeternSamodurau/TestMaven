package lesson_20.Hibernate.skillbox;

import org.hibernate.Session;

public class TestConnection {
    public static void testConnection(){

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        String sql = "SELECT version()";
        String result = (String) session1.createNativeQuery(sql).getSingleResult();
        System.out.println("My SQL version is :  " + result);

    }
}
