package ua.stqa.pft.sandbox;

import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {

        String [] langs = {"Java", "C#", "Python", "PHP"};

        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

        for (int i = 0; i < langs.length; i++) {
            System.out.println("I want to learn " + langs[i]);
        }

        System.out.println();

        for (String l : langs) {
            System.out.println("I already know " + l);
        }

        System.out.println();

        for (int i = 0; i < languages.size(); i++) {
            System.out.println("I have not learn yet " + languages.get(i));
        }

        System.out.println();

        for (String l : languages) {
            System.out.println("I dont know " + l);
        }
    }
}
