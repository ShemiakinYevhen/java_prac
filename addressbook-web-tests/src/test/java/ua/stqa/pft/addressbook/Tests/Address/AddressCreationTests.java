package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;

public class AddressCreationTests extends AddressTestBase {

    @Test
    public void testAddressCreation() {
        app.getNavigationHelper().gotoAddressCreationPage();
        app.getAddressHelper().fillNewAddress(new AddressData("test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9", "test10", "test11", "test12", "test13", "test14", "test15", "test16", "test17", "test18"));
        app.getAddressHelper().submitAddressCreation();
        app.getNavigationHelper().returnToHomePage();
    }


}
