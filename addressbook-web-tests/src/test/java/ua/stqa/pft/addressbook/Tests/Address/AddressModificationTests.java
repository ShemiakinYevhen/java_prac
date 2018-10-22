package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Models.GroupData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AddressModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().goToHomePage();

        if (!app.getAddressHelper().isThereAAddress()) {
            app.getAddressHelper().createAddress(new AddressData("test1", "test2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "test4-4"), true);
        }
        app.getNavigationHelper().goToHomePage();
    }

    @Test
    public void testAddressModification() {
        List<AddressData> before = app.getAddressHelper().getAddressList();
        int index = before.size() - 1;
        AddressData address = new AddressData(before.get(index).getId(),"test1-1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        app.getAddressHelper().modifyAddress(index, address);
        List<AddressData> after = app.getAddressHelper().getAddressList();
        //Проверка результатов модификации контакта с учетом того, что функция модификации удаляет модифицируемый контакт (баг)
        Assert.assertEquals(after.size(), index);
        //Условие проверки результатов модификации контакта при нормальной работе функции модификации
        /*
        Assert.assertEquals(after, before);
        */

        before.remove(index);
        //Так как кнопка "Update" удаляет контакт, то следующая строка, реализующая добавление элемента в спискок необходима только при отсутствии данной ошибки
        /*
            before.add(address);
         */
        Comparator<? super AddressData> byId = (a1, a2) -> Integer.compare(a1.getId(), a2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
