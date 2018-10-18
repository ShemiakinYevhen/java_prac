package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Tests.TestBase;

public class AddressesDeletionTests extends TestBase {

    @Test
    public void testAddressesDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getAddressHelper().selectAddress();
        app.getAddressHelper().submitAddressesDeletion();
        app.getAddressHelper().acceptAlert();
        app.getNavigationHelper().gotoHomePage();
    }
}
