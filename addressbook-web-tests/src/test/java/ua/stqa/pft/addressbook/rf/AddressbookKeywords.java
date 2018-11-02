package ua.stqa.pft.addressbook.rf;

import org.openqa.selenium.remote.BrowserType;
import ua.stqa.pft.addressbook.AppManager.ApplicationManager;
import ua.stqa.pft.addressbook.Models.GroupData;

import java.io.IOException;

public class AddressbookKeywords {

    public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

    private ApplicationManager app;

    public void initApplicationManager() throws IOException {
        app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
        app.init();
    }

    public void stopApplicationManager() {
        app.stop();
        app = null;
    }

    public int getGroupCount() {
        app.goTo().group();
        return app.group().count();
    }

    public void createGroup(String name, String header, String footer) {
        app.goTo().group();
        app.group().create(new GroupData().withName(name).withHeader(header).withFooter(footer));
    }
}
