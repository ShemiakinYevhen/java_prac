package ua.stqa.pft.addressbook.Tests;

import java.io.File;

public class FileToStringNStringToFileTests {
    public static void main(String[] args) {
        File file = new File ("src/test/resources/test.png");
        System.out.println(file.getAbsolutePath());
        String stringFromFile = file.toString();
        System.out.println(stringFromFile);
        File fileFromString = new File (stringFromFile);
        System.out.println(fileFromString.toString());
        System.out.println(fileFromString.getAbsolutePath());
        System.out.println(fileFromString.getPath());
    }
}
