package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

public class AddressDeletionTests extends TestBase {

    @Test
    public void testAddressDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getAddressHelper().isThereAAddress()) {
            app.getAddressHelper().createAddress(new AddressData("test1", "test2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "test4-4"), true);
            app.getNavigationHelper().gotoHomePage();
        }
        app.getNavigationHelper().gotoModificationPage();
        app.getAddressHelper().submitAddressDeletion();
        app.getNavigationHelper().gotoHomePage();
    }
}

