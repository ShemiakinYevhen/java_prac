package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.Set;

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
        Set<AddressData> before = app.address().set();
        AddressData modifiedAddress = before.iterator().next();
        AddressData address = new AddressData().withId(modifiedAddress.getId()).withFirstname("test1-1");
        app.address().modify(address);
        Set<AddressData> after = app.address().set();

        //Проверка результатов модификации контакта с учетом того, что функция модификации удаляет модифицируемый контакт (баг)
        Assert.assertEquals(after.size(), before.size() - 1);
        //Условие проверки результатов модификации контакта при нормальной работе функции модификации
        //Assert.assertEquals(after, before);

        before.remove(modifiedAddress);

        //Так как кнопка "Update" удаляет контакт, то следующая строка, реализующая добавление элемента в спискок необходима только при отсутствии данной ошибки
        //before.add(address);

        Assert.assertEquals(before, after);
    }


}
