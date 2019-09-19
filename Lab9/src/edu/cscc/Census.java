package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Census {
    public static Surname[] loadCensusData(String fname) {
        Surname[] namelist = new Surname[100];


        // TODO - Add code to read file and populate array of Surname objects
        File inputFile = new File("Surnames_2010Census.csv");

        try {
            Scanner scanner = new Scanner(inputFile);
            skipLines(scanner, 1);

            for(int i = 0; i < namelist.length; ++i){
                String values[] = scanner.nextLine().split(",");
                namelist[i] = new Surname(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]), Double.parseDouble(values[3]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return namelist;
    }

    private static void skipLines(Scanner scanner, int line) {
        for (int i = 0; i < line; i++) {
            if (scanner.hasNextLine()) scanner.nextLine();
        }
    }
}