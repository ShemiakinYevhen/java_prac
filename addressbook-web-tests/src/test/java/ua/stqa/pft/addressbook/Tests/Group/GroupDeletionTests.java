package ua.stqa.pft.addressbook.Tests.Group;

import org.testng.annotations.Test;

public class GroupDeletionTests extends GroupTestBase {
    
    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
