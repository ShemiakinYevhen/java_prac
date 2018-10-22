package ua.stqa.pft.addressbook.Tests.Group;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.GroupData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().group();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("test4").withHeader("test5"));
        }
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }



}
