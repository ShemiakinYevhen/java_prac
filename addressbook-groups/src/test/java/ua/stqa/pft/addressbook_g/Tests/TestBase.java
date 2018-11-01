package ua.stqa.pft.addressbook_g.Tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ua.stqa.pft.addressbook_g.AppManager.ApplicationManager;
//import ua.stqa.pft.addressbook.Models.ContactData;
//import ua.stqa.pft.addressbook.Models.Contacts;
import ua.stqa.pft.addressbook_g.Models.GroupData;
import ua.stqa.pft.addressbook_g.Models.Groups;
//import ua.stqa.pft.addressbook_g.Tests.Contact.ContactEditNHomePagesTests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected static ApplicationManager app;

    static {
        try {
            app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method method, Object[] p) {
        logger.info("Start test " + method.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method method, Object[] p) {
        logger.info("Stop test " + method.getName() + " with parameters " + Arrays.asList(p));
    }

    public void verifyGroupListInUI() {
        if (Boolean.getBoolean("verifyUI")) {
            Groups uiGroups = app.group().set();
            Groups dbGroups = app.db().groups();
            assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupData().withId(g.getId()).withName((g.getName())))
                    .collect(Collectors.toSet())));
        }
    }

    /*public void verifyContactListInUI() {
        if (Boolean.getBoolean("verifyUI")) {
            Contacts uiContacts = app.contact().set();
            Contacts dbContacts = app.db().contacts();
            assertThat(uiContacts, equalTo(dbContacts.stream().map((c) -> new ContactData().withId(c.getId()).withFirstname(c.getFirstname())
                    .withLastname(c.getLastname()).withAddress(c.getAddress())
                    .withAllEmails(Arrays.asList(c.getEmail(), c.getEmail2(), c.getEmail3()).stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n")))
                    .withAllPhones(Arrays.asList(c.getHomePhone(), c.getMobilePhone(), c.getWorkPhone()).stream().filter((s) -> !s.equals(""))
                            .map(ContactEditNHomePagesTests::cleaned).collect(Collectors.joining("\n"))))
                    .collect(Collectors.toSet())));
        }
    }*/
}
