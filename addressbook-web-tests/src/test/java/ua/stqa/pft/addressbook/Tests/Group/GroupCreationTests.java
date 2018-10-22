package ua.stqa.pft.addressbook.Tests.Group;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.GroupData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().group();
        Set<GroupData> before = app.group().set();
        GroupData group = new GroupData().withName("test4").withHeader("test5");
        app.group().create(group);
        Set<GroupData> after = app.group().set();

        Assert.assertEquals(after.size(), before.size() + 1);
        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);
    }
}
