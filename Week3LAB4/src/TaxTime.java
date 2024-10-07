import java.util.Scanner;

public class TaxTime {





    private static Scanner scnr = new Scanner(System.in);
    private static double incomeTotal = 0.0;
    private static double deductionsTotal = 0.0;
    private static double incomeInput;
    private static double taxable;
    private static char group;
    private static double tax;

    public static void main(String[] args) {
        input();
        computeTaxableIncome();
        computeTaxGroup();
        computeTax();
        display();
    } // end of main
    public static void input() {

        System.out.println("Enter next amount: ");
        incomeInput = scnr.nextDouble();

    while (incomeInput != 0.0) {
        if (incomeInput > 0.0) {
            incomeTotal = incomeInput + incomeTotal;
    } else {
            deductionsTotal = deductionsTotal + Math.abs(incomeInput);
        }
        System.out.println("Enter next amount: ");
        incomeInput = scnr.nextDouble();
    }
    } // end of input method

    public static void computeTaxableIncome(){
        if (incomeTotal >= deductionsTotal){
            taxable = incomeTotal - deductionsTotal;
        } else {
            taxable = 0.0;
        }
    }

    public static void computeTaxGroup(){
        if (taxable >= 500000.0) {
            group = 'S';
        } else if (taxable >= 200000.0) {
            group = 'Q';
        } else if (taxable >= 100000.0) {
            group = 'M';
        } else if (taxable >= 50000.0) {
            group = 'A';
        } else if (taxable >= 20000.0) {
            group = 'R';
        } else {
            group = 'P';
        }
    }

    public static void computeTax (){
        if ((group == 'S') || (group == 'Q')) {
            tax = 0.25 * taxable;
        } else if (group == 'M') {
            tax = 0.1 * taxable;
        } else if ((group == 'A') || (group == 'R')) {
            tax = 0.03 * taxable;
        } else if (group == 'P') {
            tax = 0.0;
        } else {
            System.out.println("Error!");
        }
    }

    public static void display (){
        System.out.println("Income         = $" + incomeTotal);
        System.out.println("Deductions     = $" + deductionsTotal);
        System.out.println("Taxable income = $" + taxable);
        System.out.println("Tax group      = " + group);
        System.out.println("Tax owed       = $" + tax);
    }
} //end of TaxTime class

