package ua.stqa.pft.mantis.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ua.stqa.pft.mantis.Models.MailMessage;

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
        String email = ("user1@localhost.localdomain");
        String username = "user1";
        app.passChange().start("administrator", "root");
        app.passChange().sendRequestToUser();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.passChange().finish(confirmationLink, newPass);
        Assert.assertTrue(app.newSession().login(username, newPass));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
