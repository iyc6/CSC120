import java.util.Scanner;

public class Qualities {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("WEEK 10 LAB 8");

        String qualities = "The qualities are ";


        System.out.println("Please enter sentences, . to end.");
        String input = keyboard.nextLine();

        while (!input.equals(".")) {


            if (input.startsWith("I am ")) {

                qualities = qualities + input.substring(5) + ", ";

            } // end of if statement

            input = keyboard.nextLine();


        } // end of while loop

        System.out.println(qualities);


    }// end of main


} //end class




