/*import java.util.Scanner;
//=================================================================================================
public class UseKindle {
    //-------------------------------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //-------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        Kindle aBook;
        int numberOfPages;

//----Get person information
        System.out.print("How many pages in the book : ");
        numberOfPages = keyboard.nextInt();

//----Create object
        aBook = new Kindle(numberOfPages);
        System.out.print("Initially                  : ");
        System.out.println(aBook);

//----Do some reading
        aBook.turnPages();
        aBook.turnPages();
        aBook.turnPages();
        aBook.turnPages();
        System.out.print("A bit later                : ");
        System.out.println(aBook);

//----Skip ahead
        aBook.turnPages(27);
        System.out.print("After skipping 27 pages    : ");
        System.out.println(aBook);
        System.out.print("You were on                : ");
        System.out.println(aBook);

//----Try skip past the end of the book
        aBook.turnPages(8);
    }
//-------------------------------------------------------------------------------------------------
}
//=================================================================================================
*/

import java.util.Arrays;
import java.util.Scanner;

public class UseKindle {
    private static final int MAX_PEOPLE = 6;
    private static final int MAX_TEETH = 8;
    private static final char MISSING_TOOTH = 'M';
    private static final char[] VALID_TEETH = {'I', 'B', 'M'};

    private static String[] familyNames;
    private static char[][][] familyTeeth;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Floridian Tooth Records\n--------------------------------------");

        int familyCount = initializeFamilyData(scanner);
        menu(scanner, familyCount);
    }

    private static int initializeFamilyData(Scanner scanner) {
        int familyCount;

        // Get family count with validation
        do {
            System.out.print("Please enter number of people in the family: ");
            familyCount = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (familyCount < 1 || familyCount > MAX_PEOPLE) {
                System.out.println("Invalid number of people, try again");
            }
        } while (familyCount < 1 || familyCount > MAX_PEOPLE);

        familyNames = new String[familyCount];
        familyTeeth = new char[familyCount][2][MAX_TEETH];

        // Get each family member's name and teeth data
        for (int i = 0; i < familyCount; i++) {
            System.out.print("Please enter the name for family member " + (i + 1) + ": ");
            familyNames[i] = scanner.nextLine();

            familyTeeth[i][0] = getValidTeeth(scanner, "uppers", familyNames[i]);
            familyTeeth[i][1] = getValidTeeth(scanner, "lowers", familyNames[i]);
        }

        return familyCount;
    }

    private static char[] getValidTeeth(Scanner scanner, String jaw, String name) {
        char[] teeth;
        do {
            System.out.print("Please enter the " + jaw + " for " + name + ": ");
            String input = scanner.nextLine().toUpperCase();

            if (input.length() > MAX_TEETH) {

                System.out.println("Too many teeth, try again");
                continue;

            } else if (!"IBMibm".contains(input)) {

                System.out.println("Invalid teeth types, try again              : ");
                continue;

            }

            teeth = input.toCharArray();
            break;

        } while (true);

        return teeth;
    }

    private static void menu(Scanner scanner, int familyCount) {
        char choice;
        do {
            System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it: ");
            choice = scanner.nextLine().toUpperCase().charAt(0);
            switch (choice) {
                case 'P': printRecords(familyCount); break;
                case 'E': extractTooth(scanner); break;
                case 'R': reportRootCanalIndex(); break;
                case 'X': System.out.println("Exiting the Floridian Tooth Records :-)\n"); break;
                default: System.out.println("Invalid menu option, try again");
            }
        } while (choice != 'X');
    }

    private static void printRecords(int familyCount) {
        for (int i = 0; i < familyCount; i++) {
            System.out.println(familyNames[i]);
            System.out.print("  Uppers: ");
            printJaw(familyTeeth[i][0]);
            System.out.print("  Lowers: ");
            printJaw(familyTeeth[i][1]);
        }
    }

    private static void printJaw(char[] jaw) {
        for (int i = 0; i < jaw.length; i++) {
            System.out.print(" " + (i + 1) + ":" + jaw[i]);
        }
        System.out.println();
    }

    private static void extractTooth(Scanner scanner) {
        System.out.print("Which family member: ");
        String name = scanner.nextLine();
        int memberIndex = getFamilyMemberIndex(name);
        if (memberIndex == -1) {
            System.out.println("Invalid family member, try again");
            return;
        }

        System.out.print("Which tooth layer (U)pper or (L)ower: ");
        char layer = scanner.nextLine().toUpperCase().charAt(0);
        int layerIndex = (layer == 'U') ? 0 : (layer == 'L') ? 1 : -1;
        if (layerIndex == -1) {
            System.out.println("Invalid layer, try again");
            return;
        }

        System.out.print("Which tooth number: ");
        int toothIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (toothIndex < 0 || toothIndex >= MAX_TEETH || familyTeeth[memberIndex][layerIndex][toothIndex] == MISSING_TOOTH) {
            System.out.println("Invalid or missing tooth, try again");
            return;
        }

        familyTeeth[memberIndex][layerIndex][toothIndex] = MISSING_TOOTH;
        System.out.println("Tooth extracted successfully.");
    }

    private static int getFamilyMemberIndex(String name) {
        for (int i = 0; i < familyNames.length; i++) {
            if (familyNames[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    private static void reportRootCanalIndex() {
        int incisorCount = 0, bicuspidCount = 0, missingCount = 0;

        for (char[][] jaws : familyTeeth) {
            for (char[] jaw : jaws) {
                for (char tooth : jaw) {
                    switch (tooth) {
                        case 'I': incisorCount++; break;
                        case 'B': bicuspidCount++; break;
                        case 'M': missingCount++; break;
                    }
                }
            }
        }

        double discriminant = Math.pow(bicuspidCount, 2) + 4 * incisorCount * missingCount;
        if (discriminant < 0) {
            System.out.println("No real root canal indices.");
        } else {
            double root1 = (-bicuspidCount + Math.sqrt(discriminant)) / (2 * incisorCount);
            double root2 = (-bicuspidCount - Math.sqrt(discriminant)) / (2 * incisorCount);
            System.out.printf("One root canal at %.2f\nAnother root canal at %.2f\n", root1, root2);
        }
    }
}