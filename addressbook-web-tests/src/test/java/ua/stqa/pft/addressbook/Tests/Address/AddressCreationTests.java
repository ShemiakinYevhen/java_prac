package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Models.Addresses;
import ua.stqa.pft.addressbook.Tests.TestBase;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class AddressCreationTests extends TestBase {

    @Test
    public void testAddressCreation() {
        app.goTo().home();
        Addresses before = app.address().set();
        AddressData address = new AddressData().withFirstname("test1").withMiddlename("test2").withGroup("test4-4");
        app.address().create(address, true);
        Assert.assertEquals(app.address().count(), before.size() + 1);
        Addresses after = app.address().set();
        assertThat(after, equalTo(before.withAdded(address.withId(after.stream().mapToInt((a) -> a.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadAddressCreation() {
        app.goTo().home();
        Addresses before = app.address().set();
        AddressData address = new AddressData().withFirstname("test1'").withMiddlename("test2").withGroup("test4-4");
        app.address().create(address, true);
        Assert.assertEquals(app.address().count(), before.size());
        Addresses after = app.address().set();
        assertThat(after, equalTo(before));
    }
}
