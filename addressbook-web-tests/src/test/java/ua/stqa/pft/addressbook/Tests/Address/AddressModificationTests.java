package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

public class AddressModificationTests extends TestBase {

    @Test
    public void testAddressModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoModificationPage();
        app.getAddressHelper().fillNewAddress(new AddressData("test1-1", "test2-2", "test3-3", "test4-4", "test5-5", "test6-6", "test7-7", "test8-8", "test9-9", "test10-10", "test11-11", "test12-12", "test13-13", "test14-14", "test15-15", "test16-16", "test17-17", "test18-18"));
        app.getAddressHelper().submitAddressModification();

    }
}
