package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

public class AddressDeletionTests extends TestBase {

    @Test
    public void testAddressDeletion() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getAddressHelper().getContactCount();
        if (!app.getAddressHelper().isThereAAddress()) {
            app.getAddressHelper().createAddress(new AddressData("test1", "test2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "test4-4"), true);
        }
        app.getNavigationHelper().goToHomePage();
        app.getAddressHelper().selectAddress();
        app.getAddressHelper().submitAddressDeletion();
        app.getAddressHelper().acceptAlert();
        app.getNavigationHelper().goToHomePage();
        int after = app.getAddressHelper().getContactCount();
        //Проверка, которой не было в курсе
        if (before == 0) {
            Assert.assertEquals(after, before);
        } else {
            Assert.assertEquals(after, before - 1);
        }
    }
}

