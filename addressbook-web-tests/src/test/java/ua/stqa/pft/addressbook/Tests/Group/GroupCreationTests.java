package ua.stqa.pft.addressbook.Tests.Group;

import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.GroupData;

public class GroupCreationTests extends GroupTestBase {

    @Test
    public void testGroupCreation() {
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("test4", "test5", "test6"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
