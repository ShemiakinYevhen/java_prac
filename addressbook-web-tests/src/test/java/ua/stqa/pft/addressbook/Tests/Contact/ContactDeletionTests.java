package ua.stqa.pft.addressbook.Tests.Contact;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ua.stqa.pft.addressbook.Models.ContactData;
import ua.stqa.pft.addressbook.Models.Contacts;
import ua.stqa.pft.addressbook.Tests.TestBase;

import static org.hamcrest.MatcherAssert.*;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions () {
        app.goTo().home();
        if (app.contact().set().size() == 0) {
            app.contact().create(new ContactData().withFirstname("test1").withLastname("test2").withGroup("test4-4")
                    .withAddress("someadrress").withPhoto("src/test/resources/test.png")
                    .withHomePhone("111").withWorkPhone("222").withMobilePhone("333")
                    .withEmail("email").withEmail2("email2").withEmail3("email3"), true);
        }
        app.goTo().home();
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.contact().set();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Assert.assertEquals(app.contact().count(), before.size() - 1);
        Contacts after = app.contact().set();
        assertThat(after, CoreMatchers.equalTo(before.without(deletedContact)));
    }


}

