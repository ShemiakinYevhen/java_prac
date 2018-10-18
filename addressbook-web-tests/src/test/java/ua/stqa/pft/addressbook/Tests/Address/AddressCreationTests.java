package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

public class AddressCreationTests extends TestBase {

    @Test
    public void testAddressCreation() {
        app.getNavigationHelper().gotoAddressCreationPage();
        app.getAddressHelper().fillNewAddress(new AddressData("test1", "test2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        app.getAddressHelper().submitAddressCreation();
        app.getNavigationHelper().gotoHomePage();
    }


}
