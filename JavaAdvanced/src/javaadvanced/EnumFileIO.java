/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaadvanced;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author S331461152
 */
public class EnumFileIO {

    public enum Grades {
        R, D, C, B, A;
    }

    static ArrayList<Grades> mark;
    static Scanner sc = new Scanner(System.in);
    
    private static void OutputFile(ArrayList<Grades> list, String filepath) throws IOException {
        ArrayList<String> List = new ArrayList<>();
        list.forEach((i) -> List.add(i.name()));
        Path file = Paths.get(filepath);
        Files.write(file, List, StandardCharsets.UTF_8);
        
    }
    public static void Intialize() throws IOException{
        File file = new File("Files/EvidenceRecord.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
       
        try (Scanner scfile = new Scanner(file)) {
            mark = new ArrayList<>();
            while (scfile.hasNext()) {
                mark.add((Grades.valueOf(scfile.next())));
            }
        }
        
        Execute();
    }
    public static void Execute() throws IOException {
        
     
        System.out.println("Welcome to the grade keeper");
        while (true) {
            System.out.println("Commands: \n 'display' = Will display all your grades \n 'input' = To input a new grade to your list \n 'exit' = To exit the program");
            String Command = sc.nextLine();
            switch (Command) {
                case "input":
                    System.out.println("Please enter a grade [A,B,C,D,R].");
                    try {
                        mark.add((Grades.valueOf(sc.next())));
                        System.out.println("Grade added");
                        OutputFile(mark, "Files/EvidenceRecord.txt");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Not an actual grade");
                    }
                    break;
                case "display":
                    System.out.println("Here is your list\n");
                    mark.forEach((i) -> System.out.println(i.name()));
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
