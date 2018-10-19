package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

public class AddressModificationTests extends TestBase {

    @Test
    public void testAddressModification() {
        app.getAddressHelper().returnToHomePage();
        if (!app.getAddressHelper().isThereAAddress()) {
            app.getAddressHelper().createAddress(new AddressData("test1", "test2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "test4-4"), true);
        }
        app.getNavigationHelper().gotoModificationPage();
        app.getAddressHelper().fillNewAddress(new AddressData("test1-1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), false);
        app.getAddressHelper().submitAddressModification();
        app.getAddressHelper().returnToHomePage();
    }
}
