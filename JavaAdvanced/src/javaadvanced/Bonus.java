package javaadvanced;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author S331471193
 */
public class Bonus {

    enum Luggage {
        Clothes, Charger, Phone, Passport, Wallet;
    }

    static ArrayList<Luggage> list = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void run() throws IOException {
        Scanner sc = new Scanner(new File("Files/LuggageChecker.txt"));
        String Inventory;
        while (sc.hasNext()) {
            // find next line
            Inventory = sc.next();
            list.add(Luggage.valueOf(Inventory));
        }

        while (true) {
            System.out.println("Would you like to add anything to the luggage? 'y' or 'n'");

            switch (s.nextLine()) {
                case "y":
                    addLuggage();
                    break;
                case "n":
                    checkStuff(list);
                    checkMissing(list);
                    System.exit(0);
            }
        }
    }

    public static void addLuggage() throws IOException {
        System.out.println("Please enter an item (Clothes, Charger, Phone, Passport, Wallet).");
        try {
            list.add((Luggage.valueOf(s.next())));
            System.out.println("Item added");
            OutputFile(list, "Files/LuggageChecker.txt");
        } catch (IllegalArgumentException e) {
            System.out.println("Not an actual item");
        }
    }

    private static void OutputFile(ArrayList<Luggage> list, String filepath) throws IOException {
        ArrayList<String> List = new ArrayList<>();
        list.forEach((i) -> List.add(i.name()));
        Path file = Paths.get(filepath);
        Files.write(file, List, StandardCharsets.UTF_8);

    }

    public static void checkStuff(ArrayList<Luggage> list) {
        int length = list.size();
        for (int i = 0; i < length; i++) {
            switch (list.get(i)) {
                case Clothes:
                    System.out.println("Clothes √");
                    break;
                case Charger:
                    System.out.println("Charger √");
                    break;
                case Phone:
                    System.out.println("Phone √");
                    break;
                case Passport:
                    System.out.println("Passport √");
                    break;
                case Wallet:
                    System.out.println("Wallet √");
                    break;
            }
        }

    }

    public static void checkMissing(ArrayList<Luggage> list) {
        ArrayList<Luggage> temp = new ArrayList<>();
        int length = list.size();
        for (Luggage i : Luggage.values()) {
            temp.add(i);
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 8; j++) {
                if (list.get(i) == temp.get(j)) {
                    temp.remove(j);
                    break;
                }

            }
            length = list.size();
        }
        if (temp.isEmpty()) {
            System.out.println("Everything is in the luggage.");
        } else {
          
            temp.sort(Collections.reverseOrder());
            System.out.printf(temp + " are missing. \n");
        }
    }

  
}
