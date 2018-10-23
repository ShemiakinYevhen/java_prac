package ua.stqa.pft.addressbook.Tests.Contact;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ua.stqa.pft.addressbook.Models.ContactData;
import ua.stqa.pft.addressbook.Models.Contacts;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        String json = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.json"))) {
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
        return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromXML() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        String xml = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.xml"))) {
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
        return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreation(ContactData contact) {
        app.goTo().home();
        Contacts before = app.contact().set();
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
