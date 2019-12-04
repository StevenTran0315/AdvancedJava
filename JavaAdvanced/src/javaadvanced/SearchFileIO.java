
package javaadvanced;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.ArrayList;

public class SearchFileIO {

    private static boolean Search(ArrayList<String> list, String keyword) {
        for (String i : list) {
            if (i.equals(keyword)) {
                return true;
            }
        }
        return false;
    }

    private static void Output(ArrayList<String> list) throws IOException {
        Path file = Paths.get("Files/Inventory.txt");
        Files.write(file, list, StandardCharsets.UTF_8);

    }

    public static void run() throws IOException {

        File f = new File("Files/Inventory.txt");
        if (!f.exists()) {
            f.createNewFile();
        }

        ArrayList<String> inventory;
        try (Scanner sc = new Scanner(f)) {
            inventory = new ArrayList<>();
            while (sc.hasNext()) {
                inventory.add(sc.next());
            }
        }

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Would you like to search or input for a food in stock? 'search' for search, 'input' for input, anything else for no");
            switch (input.nextLine()) {
                case ("search"):
                    System.out.println("Please enter the food you are looking for");
                    String food = input.nextLine();
                    if (Search(inventory, food)) {
                        System.out.println("It is in stock!");

                    } else {
                        System.out.println("None in stock");
                    }
                    break;
                case ("input"):
                    System.out.println("Please enter the food you would like to enter");
                    food = input.nextLine();
                    if (!Search(inventory, food)) {
                        inventory.add(food);
                        Output(inventory);
                        System.out.println("Food added to the inventory!");

                    } else {
                        System.out.println("This food already exists!");
                    }
                    break;
                default:
                    System.exit(0);
            }

        }

    }

}