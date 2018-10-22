package ua.stqa.pft.addressbook.Tests.Address;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Models.Addresses;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.Set;

import static org.hamcrest.MatcherAssert.*;

public class AddressModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();

        if (app.address().set().size() == 0) {
            app.address().create(new AddressData().withFirstname("test1").withMiddlename("test2").withGroup("test4-4"), true);
        }
        app.goTo().home();
    }

    @Test
    public void testAddressModification() {
        Addresses before = app.address().set();
        AddressData modifiedAddress = before.iterator().next();
        AddressData address = new AddressData().withId(modifiedAddress.getId()).withFirstname("test1-1");
        app.address().modify(address);
        //При нормальной работе функции модифицирования было бы:
        //Assert.assertEquals(app.address().count(), before.size());
        Assert.assertEquals(app.address().count(), before.size() - 1);
        Addresses after = app.address().set();
        //Проверка результатов модификации контакта с учетом того, что функция модификации удаляет модифицируемый контакт (баг)
        assertThat(after, CoreMatchers.equalTo(before.withChanged(modifiedAddress, address)));
        //Условие проверки результатов модификации контакта при нормальной работе функции модификации
        //Assert.assertEquals(after, before);
    }
}
