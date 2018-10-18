package ua.stqa.pft.addressbook.Tests.Group;

import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Tests.TestBase;

public class GroupDeletionTests extends TestBase {
    
    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
