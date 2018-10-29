package ua.stqa.pft.mantis.AppManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ua.stqa.pft.mantis.Models.UserData;
import ua.stqa.pft.mantis.Models.Users;

import java.util.List;

public class DBHelper {
    private final SessionFactory sessionFactory;

    public DBHelper() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }

    public Users users() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UserData> result = session.createQuery("from UserData").list();
        for (UserData user : result) {
            System.out.println(user);
        }
        session.getTransaction().commit();
        session.close();
        return new Users(result);
    }
}
