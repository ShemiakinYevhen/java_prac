package ua.stqa.pft.mantis.AppManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private WebDriver wd;
    private final Properties properties;

    private String browser;
    private RegistrationHelper registrationHelper;
    private FTPHelper ftp;
    private MailHelper mailHelper;
    private PasswordChangingHelper passChangingHelper;
    private DBHelper dbhelper;
    private JamesHelper jamesHelper;
    private SoapHelper soapHelper;

    public ApplicationManager(String browser) throws IOException {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    }

    public void stop() {
        if (wd != null) {
            wd.quit();
        }
    }

    public HTTPSession newSession() {
        return new HTTPSession(this);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
        if (registrationHelper == null) {
            registrationHelper = new RegistrationHelper(this);
        }
        return registrationHelper;
    }

    public WebDriver getDriver() {
        if (wd == null) {
            if (browser == BrowserType.FIREFOX) {
                wd = new FirefoxDriver();
            } else if (browser == BrowserType.CHROME) {
                wd = new ChromeDriver();
            } else if (browser == BrowserType.IE) {
                wd = new InternetExplorerDriver();
            }

            wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            wd.get(properties.getProperty("web.baseURL"));
        }
        return wd;
    }

    public FTPHelper ftp(){
        if (ftp == null) {
            ftp = new FTPHelper(this);
        }
        return ftp;
    }

    public MailHelper mail() {
        if (mailHelper == null) {
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }

    public PasswordChangingHelper passChange() {
        if (passChangingHelper == null) {
            passChangingHelper = new PasswordChangingHelper(this);
        }
        return passChangingHelper;
    }

    public DBHelper db() {
        if (dbhelper == null) {
            dbhelper = new DBHelper();
        }
        return dbhelper;
    }

    public JamesHelper james() {
        if (jamesHelper == null) {
            jamesHelper = new JamesHelper(this);
        }
        return jamesHelper;
    }

    public SoapHelper soap() {
        if (soapHelper == null) {
            soapHelper = new SoapHelper(this);
        }
        return soapHelper;
    }
}
