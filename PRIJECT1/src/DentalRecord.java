import java.util.Scanner;

/**
 * this class records the name and types of teeth in both upper and lower jaws of florida families.
 * @author Ivy Chen
 * @version 1
 */

public class DentalRecord {

    /**
     * Global Scanner object to use keyboard.
     */
    public static final Scanner keyboard = new Scanner(System.in);

    /**
     * Max family members is 6.
     * Max teeth per jaw is 8.
     * Missing tooth is M.
     */
    private static final int MAX_PEOPLE = 6;
    private static final int MAX_TEETH = 8;
    private static final char MISSING_TOOTH = 'M';

    /**
     * Array to store names of members.
     * 3D array to store teeth data: [family member][upper/lower][teeth].
     */
    private static String[] familyNames;
    private static char[][][] familyTeeth;

    /**
     * Main method.
     * @param args Command-line arguments (not used).
     */

    public static void main(String[] args) {

        int familyCount;

        System.out.println("Welcome to the Floridian Tooth Records\n--------------------------------------");

        familyCount = initializeFamilyData();
        menu(keyboard, familyCount);

    } // end of main method

    /**
     * Gather family number, name, and teeth information.
     * Ensures the number of family members and teeth configurations are within allowed limits.
     *
     * @return The number of family members recorded.
     */

    private static int initializeFamilyData( ) {

        int familyCount;
        int index;

        System.out.print("Please enter number of people in the family : ");
        familyCount = keyboard.nextInt();
        keyboard.nextLine();

        do {

            if (familyCount < 1 || familyCount > MAX_PEOPLE) {
                
                System.out.print("Invalid number of people, try again         : ");
                familyCount = keyboard.nextInt();
                keyboard.nextLine();
                
            }
            
        } while (familyCount < 1 || familyCount > MAX_PEOPLE); // end of do-while loop

        familyNames = new String[familyCount];
        familyTeeth = new char[familyCount][2][MAX_TEETH];
        
        for ( index = 0; index < familyCount; index++) {

            System.out.print("Please enter the name for family member " + (index + 1) + "   : ");
            familyNames[index] = keyboard.nextLine();

            familyTeeth[index][0] = getValidTeeth(keyboard, "uppers", familyNames[index]);
            familyTeeth[index][1] = getValidTeeth(keyboard, "lowers", familyNames[index]);

        }

        return familyCount;
    } //end of initializeFamilyData method

    /**
     * Prompts the user to input valid teeth row for upper/lower jaw.
     * Accepts 8 maximum characters ('I', 'B', 'M')
     *
     * @param keyboard The scanner used for input.
     * @param jaw Jaw type (upper or lower).
     * @param name Name of family member.
     * @return Char array representing the teeth row for the specified jaw
     */
    private static char[] getValidTeeth(Scanner keyboard, String jaw, String name) {

        char[] teeth;

        System.out.print("Please enter the " + jaw + " for " + name + "       : ");

        do {

            String input = DentalRecord.keyboard.nextLine().toUpperCase();

            if (input.length() > MAX_TEETH) {

                System.out.print("Too many teeth, try again                   : ");
                continue;

            } else if (!input.matches("[IBM]+")) {

                System.out.print("Invalid teeth types, try again              : ");
                continue;

            }

            teeth = input.toCharArray();
            break;

        } while (true);

        return teeth;

    } // end of getValidTeeth method


    /**
     * Displays menu and prompts te user to choose from options
     * (P)rint records, (E)xtract a tooth, (R)eport root canal index, or e(X)it.
     *
     * @param keyboard The scanner used for input.
     * @param familyCount The number of family members in the records.
     */
    private static void menu( Scanner keyboard, int familyCount) {

        char choice;

        do {

            System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it          : ");
            choice = DentalRecord.keyboard.nextLine().toUpperCase().charAt(0);

            switch (choice) {

                case 'P': printRecords(familyCount); break;

                case 'E': extractTooth(DentalRecord.keyboard); break;

                case 'R': reportRootCanalIndex(); break;

                case 'X': System.out.println("\nExiting the Floridian Tooth Records :-)\n"); break;

                default: System.out.println("Invalid menu option, try again              : "); break;

            }// end of switch

        } while (choice != 'X'); // end of do-while

    } // end of menu method

    /**
     * Displays family member names and upper/lower jaw teeth configuration
     *
     * @param familyCount The number of family members.
     */
    private static void printRecords(int familyCount) {

        System.out.println();

        for (int i = 0; i < familyCount; i++) {

            System.out.println(familyNames[i]);
            System.out.print("  Uppers: ");
            printJaw(familyTeeth[i][0]);
            System.out.print("  Lowers: ");
            printJaw(familyTeeth[i][1]);

        }

    } // end of printRecords

    /**
     *Display the teeth in upper or lower jaw for specific family member
     *
     * @param jaw An array representing a row of teeth in a jaw.
     */
    private static void printJaw(char[] jaw) {

        for (int i = 0; i < jaw.length; i++) {

            System.out.print(" " + (i + 1) + ":" + jaw[i]);

        }

        System.out.println();
    } // end of printJaw method

    /**
     * Prompts user for member name, jaw layer, and tooth number to extract a tooth.
     *
     * @param keyboard The scanner used for input.
     */
    private static void extractTooth(Scanner keyboard) {

        int memberIndex;
        char layer;
        int layerIndex;
        int toothIndex;
        String name;

        System.out.print("Which family member                         : ");
        name = DentalRecord.keyboard.nextLine().toUpperCase();

        memberIndex = getFamilyIndex(name);


        if (memberIndex == -1) {

            System.out.print("Invalid family member, try again            : ");
            name = DentalRecord.keyboard.nextLine().toUpperCase();

            memberIndex = getFamilyIndex(name);

        }

        System.out.print("Which tooth layer (U)pper or (L)ower        : ");

        layer = DentalRecord.keyboard.nextLine().toUpperCase().charAt(0);

        layerIndex = (layer == 'U') ? 0 : (layer == 'L') ? 1 : -1;

        if (layerIndex == -1) {

            System.out.print("Invalid layer, try again                    : ");
            layer = DentalRecord.keyboard.nextLine().toUpperCase().charAt(0);

            layerIndex = (layer == 'U') ? 0 : (layer == 'L') ? 1 : -1;

        }

        System.out.print("Which tooth number                          : ");
        toothIndex = DentalRecord.keyboard.nextInt() - 1;

        DentalRecord.keyboard.nextLine();

        if (toothIndex < 0 || toothIndex >= MAX_TEETH) {

            System.out.print("Invalid tooth number, try again             : ");
            toothIndex = DentalRecord.keyboard.nextInt() - 1;

            DentalRecord.keyboard.nextLine();

        }

        if (familyTeeth[memberIndex][layerIndex][toothIndex] == MISSING_TOOTH) {

            System.out.print("Missing tooth, try again                    : ");
            toothIndex = DentalRecord.keyboard.nextInt() - 1;

            DentalRecord.keyboard.nextLine();

        }

        familyTeeth[memberIndex][layerIndex][toothIndex] = MISSING_TOOTH;

    } // end of extractTooth method

    /**
     * Finds and returns the index of a family member by their name in the familyNames array.
     *
     * @param name Name of family member
     * @return The index of family member
     */
    private static int getFamilyIndex(String name) {

        int index;

        for (index = 0; index < familyNames.length; index++) {

            if (familyNames[index].equalsIgnoreCase(name)) {

                return index;

            }

        }

        return -1;

    } // end of getFamilyIndex method

    /**
     * Calculates and displays the root canal roots by counting incisors, bicuspids, and missing teeth.
     * Computes the roots of the equation Ix^2 + Bx - M.
     */
    private static void reportRootCanalIndex() {

        int index1;
        int incisorCount = 0;
        int bicuspidCount = 0;
        int missingCount = 0;
        double discriminant;
        double root1;
        double root2;

        for (index1 = 0; index1 < familyTeeth.length; index1++) {
            for (int index2 = 0; index2 < 2; index2++) {  // 2 layers: upper (0) and lower (1)
                for (int index3 = 0; index3 < familyTeeth[index1][index2].length; index3++) {
                    char tooth = familyTeeth[index1][index2][index3];
                    if (tooth == 'I') {
                        incisorCount++;
                    } else if (tooth == 'B') {
                        bicuspidCount++;
                    } else if (tooth == 'M') {
                        missingCount++;
                    }
                }
            }
        }

        discriminant = Math.pow(bicuspidCount, 2) + 4 * incisorCount * missingCount;
        root1 = (-bicuspidCount + Math.sqrt(discriminant)) / (2 * incisorCount);
        root2 = (-bicuspidCount - Math.sqrt(discriminant)) / (2 * incisorCount);

        System.out.printf("One root canal at     %.2f\nAnother root canal at %.2f\n", root1, root2);

        } //end of reportRootCanalIndex method

    } // end of DentalRecord class

