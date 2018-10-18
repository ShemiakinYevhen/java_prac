package ua.stqa.pft.addressbook.AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.stqa.pft.addressbook.Models.AddressData;

public class AddressHelper extends HelperBase{

    public AddressHelper(WebDriver wd) {
        super(wd);
    }

    public void submitAddressDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void submitAddressesDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void submitAddressCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }



    public void submitAddressDeleting() {
        type(By.name("searchstring"), "\\9");
    }

    public void selectAddress() {
        click(By.id("MassCB"));
    }

    public void submitAddressModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void submitAllDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void confirmAllDeletion() {
        click(By.name("OK"));
    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
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
}
