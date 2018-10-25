package ua.stqa.pft.addressbook.Tests.Contact;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ua.stqa.pft.addressbook.Models.ContactData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsNEditPagesTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().home();
            app.contact().create(new ContactData().withFirstname("test1").withLastname("test2").withGroup("test4-4")
                    .withAddress("someadrress").withPhoto("src/test/resources/test.png")
                    .withHomePhone("111").withWorkPhone("222").withMobilePhone("333")
                    .withEmail("email").withEmail2("email2").withEmail3("email3"), true);
        }
    }

    @Test
    public void testContactPhone() {
        app.goTo().home();
        ContactData contact = app.contact().set().iterator().next();
        ContactData contactDataFromEditForm = app.contact().infoFromEditForm(contact);
        ContactData contactDataFromDetailsForm = app.contact().infoFromDetailsForm(contact);

        assertThat(contactDataFromDetailsForm.getFirstname(), equalTo(contactDataFromEditForm.getFirstname()));
        assertThat(contactDataFromDetailsForm.getLastname(), equalTo(contactDataFromEditForm.getLastname()));
        assertThat(contactDataFromDetailsForm.getAddress(), equalTo(contactDataFromEditForm.getAddress()));
        assertThat(contactDataFromDetailsForm.getHomePhone(), equalTo(contactDataFromEditForm.getHomePhone()));
        assertThat(contactDataFromDetailsForm.getMobilePhone(), equalTo(contactDataFromEditForm.getMobilePhone()));
        assertThat(contactDataFromDetailsForm.getWorkPhone(), equalTo(contactDataFromEditForm.getWorkPhone()));
        assertThat(contactDataFromDetailsForm.getEmail(), equalTo(contactDataFromEditForm.getEmail()));
        assertThat(contactDataFromDetailsForm.getEmail2(), equalTo(contactDataFromEditForm.getEmail2()));
        assertThat(contactDataFromDetailsForm.getEmail3(), equalTo(contactDataFromEditForm.getEmail3()));
    }
}
