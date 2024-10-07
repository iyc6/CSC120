/**
 * This class determines whether the input is fibonacci and prime.
 * @suthor Ivy
 */

import java.util.Scanner;

public class FascinatingNumbers {

    public static final Scanner keyboard = new Scanner(System.in);
    public static final int NUM_VARS = 10;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int listInputs[] = new int[NUM_VARS];
        int number = inputNumber(listInputs);

        for (int index = 0; index < number; index++) {
            int numbers = listInputs[index];
            boolean checkPrime = checkPrime(numbers);
            boolean checkFib = checkFib(numbers);
            if (checkFib) {
                System.out.print(numbers + " is Fibonacci");
            } else {
                System.out.print(numbers + " is not Fibonacci");
            }

            if (checkPrime) {
                System.out.println("and is prime");
            } else {
                System.out.println("and is not prime");
            }
        }

    } // end of main method

    /**
     *
     *
     * @param candidate
     * @return
     */

    private static boolean checkPrime (int candidate) {

        int divisor = 2;

        while (divisor <= Math.sqrt(candidate)) {
            if (candidate % divisor == 0) {
                return(false);
            }
            divisor++;
        }
        return(true);
    } // end of checkPrime method

    /**
     *
     * @param whichNumber
     * @return current == whichNumber
     */

    private static boolean checkFib (int whichNumber) {

        int previous = 1;
        int current = 0;
        int next;

        while (current < whichNumber) {
                next = current + previous;
                previous = current;
                current = next;
        }

        return current == whichNumber;
    }

    /**
     *
     * @param array
     * @return count.
     */

    private static int inputNumber(int [] array){
        int count = 0;
        int input;

        System.out.println("Please enter numbers (0 to stop) : ");
        do {
            input = keyboard.nextInt();
            array[count] = input;
            count++;
        } while (input != 0 && count < NUM_VARS);

        return count - 1;
    } // end of inputNumber method

} // end of FascinatingNumbers class
