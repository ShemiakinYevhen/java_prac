package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.List;

public class AddressesDeletionTests extends TestBase {

    @Test
    public void testAddressesDeletion() {
        app.getNavigationHelper().goToHomePage();

        if (!app.getAddressHelper().isThereAAddress()) {
            app.getAddressHelper().createAddress(new AddressData("test1", "test2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "test4-4"), true);
        }
        app.getNavigationHelper().goToHomePage();
        List<AddressData> before = app.getAddressHelper().getAddressList();
        int index = before.size() - 1;
        app.getAddressHelper().selectAddress(index);
        app.getAddressHelper().submitAddressDeletion();
        app.getAddressHelper().acceptAlert();
        app.getNavigationHelper().goToHomePage();
        List<AddressData> after = app.getAddressHelper().getAddressList();
        Assert.assertEquals(after.size(), 0);
    }
}
