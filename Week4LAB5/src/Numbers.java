import java.util.Scanner;
public class Numbers {

    public static final Scanner keyboard = new Scanner(System.in);

    public static final int NUM_ELEMENTS = 10;


    public static void main(String[] args) {
        int[] list = new int[NUM_ELEMENTS];

        int numEntered = enterNumber(list);

        for (int i = 0; i < numEntered-1; i++) {
            int number = list[i];
            boolean checkFibonacci = checkFibonacci(number);
            boolean checkPrime = checkPrime(number);


            if (checkFibonacci) {
                System.out.print(number + " is Fibonacci");
            } else {
                System.out.print(number + " is not Fibonacci");
            }

            if (checkPrime) {
                System.out.println(" and is prime");
            } else {
                System.out.println( "and is not prime");
            }
        }

    } // end of main method


    public static int enterNumber(int [] array) {
        int i = 0;
        int input;

        System.out.println("Please enter numbers (0 to stop) : ");

        do {
            input = keyboard.nextInt();

            array[i] = input;
            i++;
        } while (input != 0);

        return i;
    } // end of input method


    public static boolean checkFibonacci(int number){

        int a = 0;
        int b = 1;

        while (b < number){
            int fibSum = a + b;
            a = b;
            b = fibSum;
        }
        return b == number;

    } // end checkFibonacci method


    public static boolean checkPrime(int number){
        for (int i = 2; i <= Math.sqrt(number) ; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    } // end checkPrime method
}
