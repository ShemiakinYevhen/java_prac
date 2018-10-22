package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.List;

public class AddressDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions () {
        app.getNavigationHelper().goToHomePage();
        if (!app.getAddressHelper().isThereAAddress()) {
            app.getAddressHelper().createAddress(new AddressData("test1", "test2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "test4-4"), true);
        }
        app.getNavigationHelper().goToHomePage();
    }

    @Test
    public void testAddressDeletion() {
        List<AddressData> before = app.getAddressHelper().getAddressList();
        app.getAddressHelper().deleteAddress(before);
        List<AddressData> after = app.getAddressHelper().getAddressList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }


}

