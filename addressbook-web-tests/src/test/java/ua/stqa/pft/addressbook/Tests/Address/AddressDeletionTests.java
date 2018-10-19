package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.List;

public class AddressDeletionTests extends TestBase {

    @Test
    public void testAddressDeletion() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getAddressHelper().isThereAAddress()) {
            app.getAddressHelper().createAddress(new AddressData("test1", "test2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "test4-4"), true);
        }
        app.getNavigationHelper().goToHomePage();
        List<AddressData> before = app.getAddressHelper().getAddressList();
        app.getAddressHelper().selectAddress(before.size() - 1);
        app.getAddressHelper().submitAddressDeletion();
        app.getAddressHelper().acceptAlert();
        app.getNavigationHelper().goToHomePage();
        List<AddressData> after = app.getAddressHelper().getAddressList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}

