/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaadvanced;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author S331461152
 */
public class Execute {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println("Enter 1 for FileIO and Searching, 2 for Sorting and Enum, 3 for Enum and FileIO and 4 for the bonus program.");
        System.out.println("There is no error handling for only this class as it serves only as a directory to the actual"
                + " files and is not being marked");
        Scanner sc = new Scanner(System.in);
        switch(sc.nextInt()){
            case 1:
                .run();
                break;
            case 2:
                EnumSorting.Execute();
                break;
            case 3:
                EnumFileIO.Intialize();
                break;
            case 4:
                .run();
                break;
        }
    }
    
}
