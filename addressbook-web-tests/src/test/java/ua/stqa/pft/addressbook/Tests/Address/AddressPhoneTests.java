package ua.stqa.pft.addressbook.Tests.Address;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqa.pft.addressbook.Models.AddressData;
import ua.stqa.pft.addressbook.Tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class AddressPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.address().set().size() == 0) {
            app.address().create(new AddressData().withFirstname("test1").withMiddlename("test2").withGroup("test4-4"), true);
        }
        app.goTo().home();
    }

    @Test
    public void testAddressPhone() {
        app.goTo().home();
        AddressData address = app.address().set().iterator().next();
        AddressData addressDataFromEditForm = app.address().infoFromEditForm(address);

        assertThat(address.getAllPhones(), equalTo(mergePhones(addressDataFromEditForm)));
    }

    public String mergePhones (AddressData address) {
        return Arrays.asList(address.getHomePhone(),  address.getMobilePhone(), address.getWorkPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(AddressPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned (String phone) {
        return phone.replaceAll ("\\s", "").replaceAll("[-()+]", "");
    }
}
