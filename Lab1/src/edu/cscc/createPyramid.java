/*
Lewis Benjamin
08/07/19
Java I Programming (33851)
This program prints a pyramid of asterisks per level corresponding to the number of levels that it is tall
*/
package edu.cscc;
import java.util.Scanner;

public  class createPyramid {
    public static void printPyramid() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of levels in the tree");
        int levels = input.nextInt();

        for (int i = 0; i < levels; i++) {
            for (int j = levels - i; j > 1; j--) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}