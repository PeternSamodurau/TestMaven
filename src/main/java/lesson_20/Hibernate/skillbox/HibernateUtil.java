package lesson_20.Hibernate.skillbox;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;

public class HibernateUtil {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    private static final File PATH = new File("src/main/resources/hibernate.cfg.xml");

    static {
        try {
            if (sessionFactory == null) {
                registry = new StandardServiceRegistryBuilder().configure(PATH).build();
                Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
        }catch (Exception e) {
            System.out.println("Initial SESSION_FACTORY failed " + e);
            if (registry != null){
                StandardServiceRegistryBuilder.destroy(registry);
            }
            throw new RuntimeException("Could not initialize SessionFactory", e);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void closeSessionFactory(){

        sessionFactory.close();
    }
}
