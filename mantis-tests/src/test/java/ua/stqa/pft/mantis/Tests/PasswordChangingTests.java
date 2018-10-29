package ua.stqa.pft.mantis.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.mantis.Models.MailMessage;
import ua.stqa.pft.mantis.Models.UserData;

import java.io.IOException;
import java.util.List;

public class PasswordChangingTests extends TestBase{

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testPasswordChanging() throws IOException {
        long now = System.currentTimeMillis();
        String newPass = String.format("password%s", now);
        UserData user = app.db().users().iterator().next();
        app.passChange().start("administrator", "root");
        app.passChange().sendRequestToUser(user);
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
        app.passChange().finish(confirmationLink, newPass);
        Assert.assertTrue(app.newSession().login(user.getUsername(), newPass));
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
