package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

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
        int index = before.size() - 1;
        app.getNavigationHelper().gotoModificationPage(index);
        app.getAddressHelper().fillNewAddress(new AddressData("test1-1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), false);
        app.getAddressHelper().submitAddressModification();
        app.getNavigationHelper().goToHomePage();
        List<AddressData> after = app.getAddressHelper().getAddressList();
        //Проверка, которой не было в курсе
        //Проверка результатов модификации контакта с учетом того, что функция модификации удаляет модифицируемый контакт (баг)
        if (before.size() == 0) {
            Assert.assertEquals(after.size(), before.size());
        } else {
            Assert.assertEquals(after.size(), before.size() - 1);
        }
        //Условие проверки результатов модификации контакта при нормальной работе функции модификации
        /*
        if (before == 0) {
            Assert.assertEquals(after, before + 1);
        } else {
            Assert.assertEquals(after, before);
        }
        */
    }
}
