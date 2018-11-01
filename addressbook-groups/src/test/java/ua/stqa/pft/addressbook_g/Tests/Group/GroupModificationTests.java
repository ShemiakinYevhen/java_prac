package ua.stqa.pft.addressbook_g.Tests.Group;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook_g.Models.GroupData;
import ua.stqa.pft.addressbook_g.Models.Groups;
import ua.stqa.pft.addressbook_g.Tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().group();
            app.group().create(new GroupData().withName("test4").withHeader("test5"));
        }
    }

    @Test
    public void testGroupModification() {
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test4-4").withHeader("test5").withFooter(modifiedGroup.getFooter());
        app.goTo().group();
        app.group().modify(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withChanged(modifiedGroup, group)));
        verifyGroupListInUI();
    }
}
