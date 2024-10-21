/**
 * this class determines the total age of each household
 * @author Ivy Chen
 * @version 1
 */

import java.util.Scanner;

public class StreetMaintenance {
    public static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("week 7 lab 6");

        /**
         * @param houseInput
         * @param houseNumbers
         * @param houseIndex
         */

        // declare house array
        System.out.println("How many houses in the street?   : ");
        int houseInput = keyboard.nextInt();

        int[] houseNumbers = new int[houseInput];
        for (int houseIndex = 0; houseIndex < houseNumbers.length ; houseIndex++) {

            System.out.println("What is the next house number?   : ");
            houseNumbers[houseIndex]= keyboard.nextInt();

        } // end of for loop

        // declare 2D array
        int [][] houseAges = new int [houseInput][];

        int rowIndex;
        int columnIndex;


        for (rowIndex = 0; rowIndex < houseAges.length; rowIndex++) {

            System.out.println("How many people live in number " + houseNumbers[rowIndex] + ":");
            int numberPeople = keyboard.nextInt();

            houseAges[rowIndex] = new int [numberPeople];

            for (columnIndex = 0; columnIndex < houseAges[rowIndex].length; columnIndex++) {

                System.out.println("What is the age of person " + (columnIndex+1));
                houseAges[rowIndex][columnIndex] = keyboard.nextInt();
            } // end of inner for loop

        } // end of outer for loop



        //DISPLAY


        for (rowIndex = 0; rowIndex < houseAges.length; rowIndex++) {

            int totalAge = 0;

            for (columnIndex = 0; columnIndex < houseAges[rowIndex].length; columnIndex++) {


                totalAge = totalAge + houseAges[rowIndex][columnIndex];

            } // end of inner for loop

            System.out.println("House " + rowIndex + " has a total age of " + totalAge);

        } // end of outer for loop


    } //end of main method

} // end of StreetMaintenence
