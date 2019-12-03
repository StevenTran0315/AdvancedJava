/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaadvanced;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author S331461152
 */
public class EnumSorting {

    public enum Clothes {
        Shirt(0), Sweaters(1), Pants(2), Socks(3);

        private final int value;

        Clothes(final int newValue) {
            value = newValue;
        }

        public int getValue() {
            return value;
        }

    }

    static ArrayList<Integer> closet;
    static Scanner sc = new Scanner(System.in);

    public static void Execute() {
        System.out.println("Welcome to the closet");
        while (true) {
            System.out.println("Commands: \n 'display' = Will display all your clothes \n 'input' = To input new clothes \n 'sort' = To sort the list of clothes \n'exit' = To exit the program");

            switch (sc.nextLine()) {
                case "display":
                    System.out.println("What are you entering into the closet [Shirt, Sweaters, Pants, Socks].");
                    try {
                        closet.add((Clothes.valueOf(sc.next())));
                        System.out.println("Clothing added");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Clothing not available");
                    }
                    break;
                case "input":
                    System.out.println("The Closet:");
                    closet.forEach((i) -> System.out.println(i.name()));
                    break;
                case "exit":
                    System.exit(0);
                case "sort":
                    qSort(closet, 0, closet.size() - 1).forEach(//Lambda to print out sorted list on same line as quicksort being called
                            (i) -> {
                                System.out.println(i);
                            }
                    );
                    break;
                default:
                    System.out.println("Invalid, try again");
                    break;
            }
        }
    }

    public static int partition(ArrayList<Integer> list, int min, int max) {
        //We choose the last number as the partition point and we rearrange the list so that
        //those less than it are placed left and those greater are placed right of it
        int center = list.get(max);
        int i = (min - 1);
        for (int j = min; j < max; j++) {
            if (list.get(j) < center) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, max);

        return i + 1;//the location of the pivot point in the sorted array
    }

    public static ArrayList<Integer> qSort(ArrayList<Integer> list, int low, int high) {

        if (low < high) {

            int pi = partition(list, low, high);//find the location of the pivot point in the final array

            qSort(list, low, pi - 1);//quicksort the lower half
            qSort(list, pi + 1, high);//quicksort the upper half (both will recursively sort the smaller and smaller groups)
        }
        return list;//The list is sorted!
    }

}
