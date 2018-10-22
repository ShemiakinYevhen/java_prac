package ua.stqa.pft.addressbook.AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.stqa.pft.addressbook.Models.AddressData;

import java.util.ArrayList;
import java.util.List;

public class AddressHelper extends HelperBase{

    public boolean isThereAAddress () {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public AddressHelper(WebDriver wd) {
        super(wd);
    }

    public void submitAddressDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void submitAddressCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void submitAddressModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
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

    public void initAddressCreation() {
        click(By.linkText("add new"));
    }

    public void createAddress(AddressData address, boolean check) {
        initAddressCreation();
        fillNewAddress(address, check);
        submitAddressCreation();
    }

    public void selectAddress(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public List<AddressData> getAddressList() {
        List<AddressData> addresses = new ArrayList<AddressData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            AddressData address = new AddressData (id, name, null,null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "test4");
            addresses.add(address);
        }
        return addresses;
    }

    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public void gotoModificationPage(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void modifyAddress(int index, AddressData address) {
        gotoModificationPage(index);
        fillNewAddress(address, false);
        submitAddressModification();
        returnToHomePage();
    }

    public void deleteAddress(List<AddressData> before) {
        selectAddress(before.size() - 1);
        submitAddressDeletion();
        acceptAlert();
        returnToHomePage();
    }
}
