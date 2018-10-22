package ua.stqa.pft.addressbook.Tests.Contact;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.ContactData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ContactEditNHomePagesTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().set().size() == 0) {
            app.contact().create(new ContactData().withFirstname("test1").withMiddlename("test2").withGroup("test4-4"), true);
        }
        app.goTo().home();
    }

    @Test
    public void testContactPhone() {
        app.goTo().home();
        ContactData contact = app.contact().set().iterator().next();
        ContactData contactDataFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactDataFromEditForm)));
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactDataFromEditForm)));
        assertThat(contact.getAddress(), equalTo(contactDataFromEditForm.getAddress()));
    }

    public String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    public String mergePhones (ContactData contact) {
        return Arrays.asList(contact.getHomePhone(),  contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactEditNHomePagesTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned (String phone) {
        return phone.replaceAll ("\\s", "").replaceAll("[-()+]", "");
    }
}
