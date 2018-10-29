package ua.stqa.pft.mantis.AppManager;

import org.openqa.selenium.By;

public class PasswordChangingHelper extends HelperBase{

    public PasswordChangingHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username, String password) {
        wd.get(app.getProperty("web.baseURL") + "/login_page.php");
        type(By.name("username"), username);
        click(By.cssSelector("input[value='Login']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
    }

    public void sendRequestToUser() {
        wd.get(app.getProperty("web.baseURL") + "/manage_user_edit_page.php?user_id=10");
        click(By.cssSelector("input[value='Reset Password']"));
    }

    public void finish(String link, String newPass) {
        wd.get(link);
        type(By.name("password"), newPass);
        type(By.name("password_confirm"), newPass);
        click(By.cssSelector("span[class='bigger-110']"));
    }
}
