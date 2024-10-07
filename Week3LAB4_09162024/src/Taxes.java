import java.util.Scanner;

public class Taxes {

    private static final Scanner keyboard = new Scanner(System.in);

    private static final double STINKING_RICH = 500000;
    private static final double QUITE_RICH = 200000;
    private static final double MIAMI_POOR = 100000;
    private static final double AVERAGE = 50000;
    private static final double REALISTIC = 20000;
    private static final double S_AND_Q = 0.25;
    private static final double M = 0.1;
    private static final double A_AND_R = 0.03;

    public static void main(String[] args) {

        double amount, income, deduction;
        double taxableIncome, taxOwed;
        char taxGroup;

        income = 0.0;
        deduction = 0.0;

        System.out.println("Enter next amount : ");
        amount = keyboard.nextDouble();
        while (amount != 0.0) {
            if (amount > 0.0) {
                income = amount + income;
            } else {
                deduction = deduction + Math.abs(amount);
            }
            System.out.println("Enter next amount : ");
            amount = keyboard.nextDouble();
        }

        taxableIncome = computeTaxableIncome(income, deduction);

        taxGroup = chooseTaxBracket(taxableIncome);

        taxOwed = computeTax(taxableIncome, taxGroup);

        displayTaxInformation(income, deduction, taxableIncome,taxOwed, taxGroup);
    } //end of main


    private static double computeTaxableIncome (double income, double deduction) {

        double taxable;

        if (income >= deduction) {
            taxable = income - deduction;
        } else {
            taxable = 0.0;
        }
        return taxable;

    } // end of computeTaxableIncome method


    private static char chooseTaxBracket (double taxableIncome) {

        if (taxableIncome >= STINKING_RICH) {
            return 'S';
        } else if (taxableIncome >= QUITE_RICH) {
            return 'Q';
        } else if (taxableIncome >= MIAMI_POOR) {
            return 'M';
        } else if (taxableIncome >= AVERAGE) {
            return 'A';
        } else if (taxableIncome >= REALISTIC) {
            return 'R';
        } else {
            return 'P';
        }
    } // end of chooseTaxBracket method


    private static double computeTax(double taxable, char group) {
        double taxOwed = 0.0;
        if ((group == 'S') || (group == 'Q')) {
            taxOwed = S_AND_Q * taxable;
        } else if (group == 'M') {
            taxOwed = M * taxable;
        } else if ((group == 'A') || (group == 'R')) {
            taxOwed = A_AND_R * taxable;
        } else if (group == 'P') {
            taxOwed = 0.0;
        } else {
            System.out.println("Error!");
        }
        return taxOwed;
    } // end of computeTax method


    private static void displayTaxInformation(double income, double deduction, double taxableIncome, double taxOwed, double taxGroup){
        System.out.println("Income         = $" + income);
        System.out.println("Deductions     = $" + deduction);
        System.out.println("Taxable income = $" + taxableIncome);
        System.out.println("Tax group      = " + taxGroup);
        System.out.println("Tax owed       = " + taxOwed);

    } // end of displayTaxInformation method

} //end of Taxes class
