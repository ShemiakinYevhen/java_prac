package ua.stqa.pft.addressbook.Models;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {

    private Set<ContactData> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactData>(contacts.delegate);
    }

    public Contacts(Collection<ContactData> contacts) {
        this.delegate = new HashSet<ContactData>(contacts);
    }

    public Contacts() {
        this.delegate = new HashSet<ContactData>();
    }

    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }

    public Contacts withAdded (ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts without (ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }

    public Contacts withChanged (ContactData before, ContactData after) {
        Contacts contacts = new Contacts(this);
        contacts.remove(before);
        //Имело бы смысл при нормальной работе функции редактирвоания
        //contacts.add(after);
        return contacts;
    }
}
