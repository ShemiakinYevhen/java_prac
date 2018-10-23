package ua.stqa.pft.addressbook.Generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ua.stqa.pft.addressbook.Models.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander Jcommander = new JCommander(generator);
        try {
            Jcommander.parse(args);
        } catch (ParameterException ex) {
            Jcommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXML(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format: " + format);
        }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (ContactData contact : contacts) {
                writer.write (String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;\n", contact.getFirstname(), contact.getLastname(),
                        contact.getGroup(), contact.getAddress(), contact.getPhoto(),
                        contact.getHomePhone(), contact.getWorkPhone(), contact.getMobilePhone(),
                        contact.getEmail(), contact.getEmail2(), contact.getEmail3()));
            }
        }
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFirstname(String.format("test_c1%s", i)).withLastname(String.format("test_c2%s", i)).withGroup("test4-4")
                    .withAddress(String.format("someadrress%s", i)).withPhoto("src/test/resources/test.png")
                    .withHomePhone(String.format("111_%s", i)).withWorkPhone(String.format("222_%s", i)).withMobilePhone(String.format("333_%s", i))
                    .withEmail(String.format("email_%s", i)).withEmail2(String.format("email2_%s", i)).withEmail3(String.format("email3_%s", i)));
        }
        return contacts;
    }
}
