package ua.stqa.pft.addressbook.AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.stqa.pft.addressbook.Models.AddressData;

public class AddressHelper extends HelperBase{

    FirefoxDriver wd;

    public AddressHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitAddressDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectAddress() {
        click(By.id("2"));
    }

    public void submitAddressCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillNewAddress(AddressData addressData) {
        type(By.name("firstname"), addressData.getFirstname());
        type(By.name("middlename"), addressData.getMiddlename());
        type(By.name("middlename"), addressData.getMiddlename());
        type(By.name("lastname"), addressData.getLastname());
        type(By.name("nickname"), addressData.getNickname());
        type(By.name("title"), addressData.getTitle());
        type(By.name("company"), addressData.getCompany());
        type(By.name("address"), addressData.getAddress());
        type(By.name("home"), addressData.getHome());
        type(By.name("mobile"), addressData.getMobile());
        type(By.name("work"), addressData.getWork());
        type(By.name("fax"), addressData.getFax());
        type(By.name("email"), addressData.getEmail());
        type(By.name("email2"), addressData.getEmail2());
        type(By.name("email3"), addressData.getEmail3());
        type(By.name("homepage"), addressData.getHomepage());
        type(By.name("address2"), addressData.getAddress2());
        type(By.name("phone2"), addressData.getPhone2());
        type(By.name("notes"), addressData.getNotes());
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void submitAddressDeleting() {
        type(By.name("searchstring"), "\\9");
    }

    public void selectingAddress() {
        if (!wd.findElement(By.id("MassCB")).isSelected()) {
            click(By.id("MassCB"));
        }
    }
}
