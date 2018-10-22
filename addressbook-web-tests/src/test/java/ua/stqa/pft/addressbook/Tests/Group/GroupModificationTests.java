package ua.stqa.pft.addressbook.Tests.Group;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.GroupData;
import ua.stqa.pft.addressbook.Models.Groups;
import ua.stqa.pft.addressbook.Tests.TestBase;

import static org.hamcrest.MatcherAssert.*;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().group();
        if (app.group().set().size() == 0) {
            app.group().create(new GroupData().withName("test4").withHeader("test5"));
        }
    }

    @Test
    public void testGroupModification() {
        Groups before = app.group().set();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test4-4").withHeader("test5");
        app.group().modify(group);
        Groups after = app.group().set();
        Assert.assertEquals(after.size(), before.size());
        assertThat(after, CoreMatchers.equalTo(before.withChanged(modifiedGroup, group)));
    }
}
