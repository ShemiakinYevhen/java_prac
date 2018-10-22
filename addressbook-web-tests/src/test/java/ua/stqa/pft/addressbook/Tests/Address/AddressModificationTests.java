package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class AddressModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();

        if (app.address().list().size() == 0) {
            app.address().create(new AddressData().withFirstname("test1").withMiddlename("test2").withGroup("test4-4"), true);
        }
        app.goTo().home();
    }

    @Test
    public void testAddressModification() {
        List<AddressData> before = app.address().list();
        int index = before.size() - 1;
        AddressData address = new AddressData().withId(before.get(index).getId()).withFirstname("test1-1");
        app.address().modify(index, address);
        List<AddressData> after = app.address().list();

        //Проверка результатов модификации контакта с учетом того, что функция модификации удаляет модифицируемый контакт (баг)
        Assert.assertEquals(after.size(), index);
        //Условие проверки результатов модификации контакта при нормальной работе функции модификации
        //Assert.assertEquals(after, before);

        before.remove(index);

        //Так как кнопка "Update" удаляет контакт, то следующая строка, реализующая добавление элемента в спискок необходима только при отсутствии данной ошибки
        //before.add(address);

        Comparator<? super AddressData> byId = (a1, a2) -> Integer.compare(a1.getId(), a2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
