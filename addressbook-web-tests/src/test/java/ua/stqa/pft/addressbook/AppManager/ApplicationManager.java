package ua.stqa.pft.addressbook.AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    FirefoxDriver wd;

    private AddressHelper addressHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;

    public void init() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.23.0-win64\\geckodriver.exe");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        addressHelper = new AddressHelper(wd);
        sessionHelper.login("admin", "secret");
    }


    public void stop() {
        wd.quit();
    }

    public AddressHelper getAddressHelper() {
        return addressHelper;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
