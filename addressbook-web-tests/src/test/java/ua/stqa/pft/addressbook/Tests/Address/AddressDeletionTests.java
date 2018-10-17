package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressDeletionTests extends AddressTestBase{

    @Test
    public void AddressDeletionTests() {
        applicationManager.selectAddress();
        applicationManager.submitAddressDeletion();
        applicationManager.returnToHomePage();
    }

}
