package ua.stqa.pft.mantis.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.mantis.Models.MailMessage;
import ua.stqa.pft.mantis.Models.UserData;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException {
        long now = System.currentTimeMillis();
        UserData user = new UserData().withEmail(String.format("user1%s@localhost.localdomain", now))
                .withUsername(String.format("user1%s", now)).withPassword("password");
        app.registration().start(user.getUsername(), user.getEmail());
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
        app.registration().finish(confirmationLink, user.getPassword());
        assertTrue(app.newSession().login(user.getUsername(),  user.getPassword()));
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
