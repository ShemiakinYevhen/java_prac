package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Tests.TestBase;

public class AddressDeletionTests extends TestBase {

    @Test
    public void testAddressDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoModificationPage();
        app.getAddressHelper().submitAddressDeletion();
        app.getNavigationHelper().gotoHomePage();
    }
}

