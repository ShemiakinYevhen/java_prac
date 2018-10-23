package ua.stqa.pft.addressbook.Tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ua.stqa.pft.addressbook.AppManager.ApplicationManager;
import ua.stqa.pft.addressbook.Tests.Group.GroupCreationTests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

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
}
