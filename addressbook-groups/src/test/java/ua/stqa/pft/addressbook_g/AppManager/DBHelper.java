package ua.stqa.pft.addressbook_g.AppManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import ua.stqa.pft.addressbook.Models.ContactData;
//import ua.stqa.pft.addressbook.Models.Contacts;
import ua.stqa.pft.addressbook_g.Models.GroupData;
import ua.stqa.pft.addressbook_g.Models.Groups;

import java.util.List;

public class DBHelper{
    private final SessionFactory sessionFactory;

    public DBHelper() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }

    public Groups groups() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupData> result = session.createQuery("from GroupData").list();
        for (GroupData group : result) {
            System.out.println(group);
        }
        session.getTransaction().commit();
        session.close();
        return new Groups(result);
    }

    /*public Contacts contacts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ContactData> result = session.createQuery("from ContactData where deprecated = '0000-00-00'").list();
        for (ContactData contact : result) {
            System.out.println(contact);
        }
        session.getTransaction().commit();
        session.close();
        return new Contacts(result);
    }*/
}
