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
        int index;
        if (before == 0) {
            index = 0;
        } else {
            index = before - 1;
        }
        app.getAddressHelper().selectAddress(index);
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

