package ua.stqa.pft.addressbook.AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void gotoGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void gotoAddressCreationPage() {
        wd.findElement(By.linkText("add new")).click();
    }
}
