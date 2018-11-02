package ua.stqa.pft.addressbook.Tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import ua.stqa.pft.addressbook.AppManager.ApplicationManager;
import ua.stqa.pft.addressbook.Models.ContactData;
import ua.stqa.pft.addressbook.Models.Contacts;
import ua.stqa.pft.addressbook.Models.GroupData;
import ua.stqa.pft.addressbook.Models.Groups;
import ua.stqa.pft.addressbook.Tests.Contact.ContactEditNHomePagesTests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
@Listeners({MyTestListener.class})
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
    public void setUp(ITestContext context) throws Exception {
        app.init();
        context.setAttribute("app", app);
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

    public void verifyContactListInUI() {
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
    }
}
