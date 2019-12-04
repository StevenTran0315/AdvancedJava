/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaadvanced;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class SortRecursion {

    // A function to implement bubble sort
    static Scanner sc = new Scanner(System.in);

    static void bubbleSort(int arr[], int n) {
        // Base case 
        if (n == 1) {
            return;
        }

        // One pass of bubble sort. After 
        // this pass, the largest element 
        // is moved (or bubbled) to end. 
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // swap arr[i], arr[i+1] 
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Largest element is fixed, 
        // recur for remaining array 
        bubbleSort(arr, n - 1);
    }

    // Driver Method 
    public static void run() {

        int i = 0;
        System.out.println("This program will sort an inputted array \n How many integers are you inputting?");
        int arr[] = new int[sc.nextInt()];
        while (i < arr.length) {
            System.out.println("Please enter in an integer, 'exit' to sort the array");
            String num = sc.nextLine();
            try {
                i++;
                arr[i] = (sc.nextInt());
            } catch (Exception e) {
                if (num.equals("exit")) {
                    break;

                } else {
                    System.out.println("Please enter a valid number!");
                }
            }
        }
        bubbleSort(arr, arr.length);

        System.out.println("Sorted array : ");
        System.out.println(Arrays.toString(arr));
    }
}
