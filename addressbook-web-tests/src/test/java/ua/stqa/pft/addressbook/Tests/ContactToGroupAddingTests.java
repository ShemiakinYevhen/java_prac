package ua.stqa.pft.addressbook.Tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.ContactData;
import ua.stqa.pft.addressbook.Models.Contacts;
import ua.stqa.pft.addressbook.Models.GroupData;
import ua.stqa.pft.addressbook.Models.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactToGroupAddingTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().group();
            app.group().create(new GroupData().withName("precName").withHeader("precHeader").withFooter("precFooter"));
        }
        if (app.db().contacts().size() == 0) {
            app.goTo().home();
            app.contact().create(new ContactData().withFirstname("test1").withLastname("test2")
                    .withAddress("someadrress").withPhoto("src/test/resources/test.png")
                    .withHomePhone("111").withWorkPhone("222").withMobilePhone("333")
                    .withEmail("email").withEmail2("email2").withEmail3("email3").inGroup(app.db().groups().iterator().next()), true);
        }
    }

    @Test
    public void testContactToGroupAdding() {
        ContactData contact = app.db().contacts().iterator().next();
        GroupData group = app.db().groups().iterator().next();
        Groups beforeGroupsOfContact = contact.getGroups();
        Contacts beforeContactsOfGroup = group.getContacts();
        app.goTo().home();
        app.contact().addContactToGroup(contact.getId(), group.getName());
        Groups afterGroupsOfContact = contact.getGroups();
        Contacts afterContactsOfGroup = group.getContacts();
        beforeContactsOfGroup.add(contact);
        beforeGroupsOfContact.add(group);
        assertThat(beforeContactsOfGroup, equalTo(afterContactsOfGroup));
        assertThat(beforeGroupsOfContact, equalTo(afterGroupsOfContact));
    }


}
