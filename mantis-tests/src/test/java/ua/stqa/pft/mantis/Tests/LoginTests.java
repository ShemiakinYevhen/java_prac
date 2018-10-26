package ua.stqa.pft.mantis.Tests;

import org.testng.annotations.Test;
import ua.stqa.pft.mantis.AppManager.HTTPSession;

import java.io.IOException;

import static org.testng.Assert.*;

public class LoginTests extends TestBase{

    @Test
    public void testLogin() throws IOException {
        HTTPSession session = app.newSession();
        assertTrue(session.login("administrator", "root"));
        assertTrue(session.isLoggedInAs("administrator"));
    }
}
