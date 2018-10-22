package ua.stqa.pft.addressbook.Tests.Contact;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.ContactData;
import ua.stqa.pft.addressbook.Models.Contacts;
import ua.stqa.pft.addressbook.Tests.TestBase;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().home();
        Contacts before = app.contact().set();
        ContactData contact = new ContactData().withFirstname("test1").withLastname("test2").withGroup("test4-4")
                .withAddress("someadrress")
                .withHomePhone("111").withWorkPhone("222").withMobilePhone("333")
                .withEmail("email").withEmail2("email2").withEmail3("email3");
        app.contact().create(contact, true);
        Assert.assertEquals(app.contact().count(), before.size() + 1);
        Contacts after = app.contact().set();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((a) -> a.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadContactCreation() {
        app.goTo().home();
        Contacts before = app.contact().set();
        ContactData contact = new ContactData().withFirstname("test1'").withLastname("test2").withGroup("test4-4");
        app.contact().create(contact, true);
        Assert.assertEquals(app.contact().count(), before.size());
        Contacts after = app.contact().set();
        assertThat(after, equalTo(before));
    }
}
