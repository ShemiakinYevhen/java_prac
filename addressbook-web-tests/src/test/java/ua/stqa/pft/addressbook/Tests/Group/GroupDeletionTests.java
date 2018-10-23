package ua.stqa.pft.addressbook.Tests.Group;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ua.stqa.pft.addressbook.Models.GroupData;
import ua.stqa.pft.addressbook.Models.Groups;
import ua.stqa.pft.addressbook.Tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
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
        assertThat(app.group().count(), equalTo(before.size() - 1));
        Groups after = app.group().set();
        assertThat(after, CoreMatchers.equalTo(before.without(deletedGroup)));
    }



}
