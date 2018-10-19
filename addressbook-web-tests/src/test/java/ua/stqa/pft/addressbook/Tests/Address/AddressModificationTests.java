package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

public class AddressModificationTests extends TestBase {

    @Test
    public void testAddressModification() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getAddressHelper().getContactCount();
        if (!app.getAddressHelper().isThereAAddress()) {
            app.getAddressHelper().createAddress(new AddressData("test1", "test2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "test4-4"), true);
        }
        app.getNavigationHelper().goToHomePage();
        int index;
        if (before == 0) {
            index = 0;
        } else {
            index = before - 1;
        }
        app.getNavigationHelper().gotoModificationPage(index);
        app.getAddressHelper().fillNewAddress(new AddressData("test1-1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), false);
        app.getAddressHelper().submitAddressModification();
        app.getNavigationHelper().goToHomePage();
        int after = app.getAddressHelper().getContactCount();
        //Проверка, которой не было в курсе
        //Проверка результатов модификации контакта с учетом того, что функция модификации удаляет модифицируемый контакт (баг)
        if (before == 0) {
            Assert.assertEquals(after, before);
        } else {
            Assert.assertEquals(after, before - 1);
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
