package ua.stqa.pft.addressbook.AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Models.Addresses;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddressHelper extends HelperBase{

    public AddressHelper(WebDriver wd) {
        super(wd);
    }

    public void create(AddressData address, boolean check) {
        initAddressCreation();
        fillNewAddress(address, check);
        submitAddressCreation();
        returnToHomePage();
    }

    public void modify(AddressData address) {
        gotoModificationPage(address.getId());
        fillNewAddress(address, false);
        submitAddressModification();
        returnToHomePage();
    }

    public void delete(AddressData address) {
        selectAddress(address.getId());
        submitAddressDeletion();
        acceptAlert();
        returnToHomePage();
    }

    public void initAddressCreation() {
        click(By.linkText("add new"));
    }

    public void fillNewAddress(AddressData addressData, boolean creation) {
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
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(addressData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitAddressCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void gotoModificationPage(int id) {
        wd.findElement(By.cssSelector("a[href*='edit.php?id=" + id + "']")).click();
    }

    public void submitAddressModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void selectAddress(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void submitAddressDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }

    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public Addresses set() {
        Addresses addresses = new Addresses();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            addresses.add(new AddressData ().withId(id).withFirstname(name).withGroup("test4"));
        }
        return addresses;
    }
}
