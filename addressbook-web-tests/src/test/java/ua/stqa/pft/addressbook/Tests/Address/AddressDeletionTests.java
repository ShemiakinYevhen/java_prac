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
        app.goTo().home();
        if (app.address().list().size() == 0) {
            app.address().create(new AddressData("test1", "test2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "test4-4"), true);
        }
        app.goTo().home();
    }

    @Test
    public void testAddressDeletion() {
        List<AddressData> before = app.address().list();
        app.address().delete(before);
        List<AddressData> after = app.address().list();

        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }


}

