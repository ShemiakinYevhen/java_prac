package ua.stqa.pft.addressbook.AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void gotoAddressCreationPage() {
        click(By.linkText("add new"));
    }
}
