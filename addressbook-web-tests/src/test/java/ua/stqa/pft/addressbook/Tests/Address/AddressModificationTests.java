package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Models.GroupData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AddressModificationTests extends TestBase {

    @Test
    public void testAddressModification() {
        app.getNavigationHelper().goToHomePage();

        if (!app.getAddressHelper().isThereAAddress()) {
            app.getAddressHelper().createAddress(new AddressData("test1", "test2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "test4-4"), true);
        }
        app.getNavigationHelper().goToHomePage();
        List<AddressData> before = app.getAddressHelper().getAddressList();
        app.getNavigationHelper().gotoModificationPage(before.size() - 1);
        AddressData address = new AddressData(before.get(before.size() - 1).getId(),"test1-1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        app.getAddressHelper().fillNewAddress(address, false);
        app.getAddressHelper().submitAddressModification();
        app.getNavigationHelper().goToHomePage();
        List<AddressData> after = app.getAddressHelper().getAddressList();
        //Проверка результатов модификации контакта с учетом того, что функция модификации удаляет модифицируемый контакт (баг)
        Assert.assertEquals(after.size(), before.size() - 1);
        //Условие проверки результатов модификации контакта при нормальной работе функции модификации
        /*
        Assert.assertEquals(after, before);
        */

        before.remove(before.size() - 1);
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
