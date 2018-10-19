package ua.stqa.pft.addressbook.Tests.Group;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.GroupData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.List;

public class GroupDeletionTests extends TestBase {
    
    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();

        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test4", "test5", null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        int index = before.size() - 1;
        app.getGroupHelper().selectGroup(index);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        //Проверка, которой не было в курсе
        if (before.size() == 0) {
            Assert.assertEquals(after.size(), before.size());
        } else {
            Assert.assertEquals(after.size(), before.size() - 1);
        }
    }

}
