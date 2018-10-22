package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.Set;

public class AddressCreationTests extends TestBase {

    @Test
    public void testAddressCreation() {
        app.goTo().home();
        Set<AddressData> before = app.address().set();
        AddressData address = new AddressData().withFirstname("test1").withMiddlename("test2").withGroup("test4-4");
        app.address().create(address, true);
        Set<AddressData> after = app.address().set();

        Assert.assertEquals(after.size(), before.size() + 1);
        address.withId(after.stream().mapToInt((a) -> a.getId()).max().getAsInt());
        before.add(address);
        Assert.assertEquals(before, after);

    }
}
