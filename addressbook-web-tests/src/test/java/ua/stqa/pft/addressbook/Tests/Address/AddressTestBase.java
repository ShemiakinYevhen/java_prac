package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.stqa.pft.addressbook.AppManager.ApplicationManager;

public class AddressTestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
