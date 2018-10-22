package ua.stqa.pft.addressbook.Tests.Group;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.GroupData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().group();
        List<GroupData> before = app.group().list();
        GroupData group = new GroupData().withName("test4").withHeader("test5");
        app.group().create(group);
        List<GroupData> after = app.group().list();

        Assert.assertEquals(after.size(), before.size() + 1);
        group.withId(after.stream().max((o1, o2) -> (Integer.compare(o1.getId(), o2.getId()))).get().getId());
        before.add(group);
        Assert.assertEquals(new HashSet<>(before), new HashSet< >(after));
    }
}
