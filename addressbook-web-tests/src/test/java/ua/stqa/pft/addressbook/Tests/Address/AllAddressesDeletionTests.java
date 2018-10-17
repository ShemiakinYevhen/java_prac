package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.Test;

public class AllAddressesDeletionTests extends AddressTestBase {

    @Test
    public void AddressDeletionTests1() {

        app.getAddressHelper().selectingAddress();
        app.getAddressHelper().submitAddressDeleting();
        app.getAddressHelper().returnToHomePage();
    }
}

