package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.HashSet;
import java.util.List;

public class AddressCreationTests extends TestBase {

    @Test
    public void testAddressCreation() {
        app.goTo().home();
        List<AddressData> before = app.address().list();
        AddressData address = new AddressData("test1", "test2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "test4-4");
        app.address().create(address, true);
        List<AddressData> after = app.address().list();

        Assert.assertEquals(after.size(), before.size() + 1);
        address.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(address);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));

    }
}
