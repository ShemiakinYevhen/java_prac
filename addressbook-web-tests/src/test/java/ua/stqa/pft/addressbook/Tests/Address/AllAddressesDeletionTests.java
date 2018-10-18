package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.Test;

public class AllAddressesDeletionTests extends AddressTestBase {

    @Test
    public void testAllAddressDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getAddressHelper().selectingAddress();
        app.getAddressHelper().submitAddressDeleting();
        app.getNavigationHelper().gotoHomePage();
    }
}

