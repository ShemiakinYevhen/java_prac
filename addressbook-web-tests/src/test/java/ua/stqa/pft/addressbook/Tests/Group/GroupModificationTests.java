package ua.stqa.pft.addressbook.Tests.Group;

import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.GroupData;

public class GroupModificationTests extends GroupTestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test4-4", "test5-5", "test6-6"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
