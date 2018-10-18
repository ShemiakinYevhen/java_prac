package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.Test;

public class AddressesDeletionTests extends AddressTestBase {

    @Test
    public void testAddressesDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getAddressHelper().selectAddress();
        app.getAddressHelper().submitAddressesDeletion();
        app.getAddressHelper().acceptAlert();
        app.getNavigationHelper().gotoHomePage();
    }
}
