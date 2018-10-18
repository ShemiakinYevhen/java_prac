package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

public class AddressesDeletionTests extends TestBase {

    @Test
    public void testAddressesDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getAddressHelper().isThereAAddress()) {
            app.getNavigationHelper().gotoAddressCreationPage();
            app.getAddressHelper().createAddress(new AddressData("test1", "test2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "test4-4"), true);
            app.getNavigationHelper().gotoHomePage();
        }
        app.getAddressHelper().selectAddress();
        app.getAddressHelper().submitAddressesDeletion();
        app.getAddressHelper().acceptAlert();
        app.getNavigationHelper().gotoHomePage();
    }
}
