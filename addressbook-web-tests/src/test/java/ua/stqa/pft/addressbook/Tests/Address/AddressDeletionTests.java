package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.Test;

public class AddressDeletionTests extends AddressTestBase {

    @Test
    public void testAddressDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoModificationPage();
        app.getAddressHelper().submitAddressDeletion();
        app.getNavigationHelper().gotoHomePage();
    }
}

