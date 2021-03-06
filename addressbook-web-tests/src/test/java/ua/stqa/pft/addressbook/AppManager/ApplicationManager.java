package ua.stqa.pft.addressbook.AppManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    private final Properties properties;

    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String browser;
    private DBHelper dbhelper;

    public ApplicationManager(String browser) throws IOException {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");

        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        dbhelper = new DBHelper();
        if ("".equals(properties.getProperty("selenium.server"))) {
            if (browser == BrowserType.FIREFOX) {
                wd = new FirefoxDriver();
            } else if (browser == BrowserType.CHROME) {
                wd = new ChromeDriver();
            } else if (browser == BrowserType.IE) {
                wd = new InternetExplorerDriver();
            }
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.fromString(System.getProperty("platform", "win8")));
            wd = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
        }


        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseURL"));
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

    }


    public void stop() {
        wd.quit();
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public DBHelper db() {

        return dbhelper;
    }

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
    }
}
