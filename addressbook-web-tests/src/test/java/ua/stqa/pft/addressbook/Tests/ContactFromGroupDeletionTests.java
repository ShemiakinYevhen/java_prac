package ua.stqa.pft.addressbook.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.ContactData;
import ua.stqa.pft.addressbook.Models.Contacts;
import ua.stqa.pft.addressbook.Models.GroupData;
import ua.stqa.pft.addressbook.Models.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactFromGroupDeletionTests extends TestBase{
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
    public void testContactFromGroupDeletion() {
        ContactData contact = app.db().contacts().iterator().next();
        if (contact.getGroups().size() == 0) {
            GroupData groupForCheck = app.db().groups().iterator().next();
            app.contact().addContactToGroup(contact.getId(), groupForCheck.getName());
            contact.inGroup(groupForCheck);
            groupForCheck.withContacts(contact);
        }
        GroupData group = contact.getGroups().iterator().next();
        Groups beforeGroupsOfContact = app.db().contacts().iterator().next().getGroups();
        Contacts beforeContactsOfGroup = app.db().groups().iterator().next().getContacts();
        app.goTo().home();
        app.contact().deleteContactFromGroup(contact.getId(), group.getName());
        Groups afterGroupsOfContact = app.db().contacts().iterator().next().getGroups();
        Contacts afterContactsOfGroup = app.db().groups().iterator().next().getContacts();
        beforeContactsOfGroup.remove(contact);
        beforeGroupsOfContact.remove(group);
        assertThat(beforeContactsOfGroup, equalTo(afterContactsOfGroup));
        assertThat(beforeGroupsOfContact, equalTo(afterGroupsOfContact));
    }
}
