package ua.stqa.pft.addressbook.Tests.Address;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Models.Addresses;
import ua.stqa.pft.addressbook.Tests.TestBase;

import static org.hamcrest.MatcherAssert.*;

public class AddressDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions () {
        app.goTo().home();
        if (app.address().set().size() == 0) {
            app.address().create(new AddressData().withFirstname("test1").withMiddlename("test2").withGroup("test4-4"), true);
        }
        app.goTo().home();
    }

    @Test
    public void testAddressDeletion() {
        Addresses before = app.address().set();
        AddressData deletedAddress = before.iterator().next();
        app.address().delete(deletedAddress);
        Addresses after = app.address().set();
        Assert.assertEquals(after.size(), before.size() - 1);
        assertThat(after, CoreMatchers.equalTo(before.without(deletedAddress)));
    }


}

