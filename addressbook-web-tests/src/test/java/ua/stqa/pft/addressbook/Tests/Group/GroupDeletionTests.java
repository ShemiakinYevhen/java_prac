package ua.stqa.pft.addressbook.Tests.Group;

import org.testng.annotations.Test;

public class GroupDeletionTests extends GroupTestBase {
    
    @Test
    public void testGroupDeletion() {
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returnToGroupPage();
    }

}
