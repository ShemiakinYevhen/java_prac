package ua.stqa.pft.addressbook.Tests.Group;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.GroupData;
import ua.stqa.pft.addressbook.Models.Groups;
import ua.stqa.pft.addressbook.Tests.TestBase;


import static org.hamcrest.MatcherAssert.*;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().group();
        if (app.group().set().size() == 0) {
            app.group().create(new GroupData().withName("test4").withHeader("test5"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.group().set();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Groups after = app.group().set();
        Assert.assertEquals(after.size(), before.size() - 1);
        assertThat(after, CoreMatchers.equalTo(before.without(deletedGroup)));
    }



}
