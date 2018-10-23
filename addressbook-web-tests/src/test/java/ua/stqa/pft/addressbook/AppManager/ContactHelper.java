package ua.stqa.pft.addressbook.AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.stqa.pft.addressbook.Models.ContactData;
import ua.stqa.pft.addressbook.Models.Contacts;

import java.io.File;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void create(ContactData contact, boolean check) {
        initContactCreation();
        fillNewContact(contact, check);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        gotoModificationPage(contact.getId());
        fillNewContact(contact, false);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContact(contact.getId());
        submitContactDeletion();
        acceptAlert();
        contactCache = null;
        returnToHomePage();
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillNewContact(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomepage());
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("phone2"), contactData.getPhone2());
        type(By.name("notes"), contactData.getNotes());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        if (contactData.getPhoto() != null) {
            attach(By.name("photo"), new File(contactData.getPhoto()));
        }
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void gotoModificationPage(int id) {
        wd.findElement(By.cssSelector("a[href*='edit.php?id=" + id + "']")).click();
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void selectContact(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void submitContactDeletion() {
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

    public int count() {
        return wd.findElements(By.xpath("//tr[@name='entry']")).size();
    }

    Contacts contactCache = null;

    public Contacts set() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            List <WebElement> cells = element.findElements(By.tagName("td"));
            String firstname = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData ().withId(id).withFirstname(firstname).withGroup("test4")
                    .withAllPhones(allPhones).withAddress(address).withAllEmails(allEmails));
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        gotoModificationPage(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withFirstname(firstname).withLastname(lastname).withHomePhone(home).withWorkPhone(work)
                .withMobilePhone(mobile)
                .withAddress(address)
                .withEmail(email1).withEmail2(email2).withEmail3(email3);
    }

    public ContactData infoFromDetailsForm(ContactData contact) {
        gotoDetailsPage(contact.getId());
        String [] Text = wd.findElement(By.xpath("//div[@id='content']")).getText().split("\n");
        String [] names = Text[0].split(" ");
        String [] phones = new String [3];
        for (int i = 0; i < 3; i++) {
            phones[i] = Text[i+4].replaceAll("\"", "").replaceAll("[a-z, A-Z]: ", "");
        }
        String [] emails = new String [3];
        for (int i = 0; i < 3; i++) {
            emails[i] = Text[i+8];
        }
        wd.navigate().back();
        return new ContactData().withFirstname(names[0]).withLastname(names[1])
                .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2])
                .withAddress(Text[2])
                .withEmail(emails[0]).withEmail2(emails[1]).withEmail3(emails[2]);
    }

    private void gotoDetailsPage(int id) {
        wd.findElement(By.cssSelector("a[href*='view.php?id=" + id + "']")).click();
    }
}
