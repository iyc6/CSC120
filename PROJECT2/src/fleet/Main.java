package fleet;

import java.io.*;
import java.util.Scanner;

/**
 * Main class for the Fleet Management System.
 * This class serves as the entry point for the application,
 * allowing users to manage a fleet of boats.
 */
public class Main {

    private static FleetManager fleetManager = new FleetManager();

    /**
     * The main method for the Fleet Management System.
     * Handles the user interface, menu options, and primary operations.
     *
     * @param args Command-line arguments. If provided, the first argument
     *             is used as the path to a CSV file for initializing the fleet.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (args.length > 0) {

            loadCSV(args[0]);

        } else {

            loadSerializedFile();

        }

        System.out.println("Welcome to the Fleet Management System\n" + "--------------------------------------");

        while (true) {

            String menuChoice;

            System.out.println("\n(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it : ");
            menuChoice = scanner.nextLine().trim().toUpperCase();

            switch (menuChoice) {

                case "P":

                    fleetManager.printFleet();
                    break;
                case "A":

                    String csvData;

                    System.out.println("Please enter the new boat CSV data          : ");
                    csvData = scanner.nextLine();

                    addBoatFromCSV(csvData);
                    break;

                case "R":

                    String boatToRemove;
                    System.out.println("Which boat do you want to remove?           : ");
                    boatToRemove = scanner.nextLine();

                    if (!fleetManager.removeBoat(boatToRemove)) {

                        System.out.println("Cannot find boat " + boatToRemove);

                    }
                    break;

                case "E":

                    String boatToSpend;
                    double amount;
                    double remainingBudget;
                    System.out.println("Which boat do you want to spend on?         : ");
                    boatToSpend = scanner.nextLine();

                    Boat targetBoat = fleetManager.findBoatByName(boatToSpend);

                    if (targetBoat == null) {

                        System.out.println("Cannot find boat " + boatToSpend);
                        break;

                    }

                    System.out.println("How much do you want to spend?              : ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();

                    if (fleetManager.authorizeExpense(boatToSpend, amount)) {

                        System.out.printf("Expense authorized, $%.2f spent.%n", targetBoat.getExpenses());

                    } else {

                        targetBoat = fleetManager.findBoatByName(boatToSpend);

                        if (targetBoat != null) {

                            remainingBudget = targetBoat.getPurchasePrice() - targetBoat.getExpenses();
                            System.out.printf("Expense not permitted, only $%.2f left to spend.%n", remainingBudget);

                        }

                    }
                    break;

                case "X":

                    saveToSerializedFile();
                    System.out.println("Exiting the Fleet Management System");
                    return;

                default:

                    System.out.println("Invalid menu option, try again.");

            } // end of switch

        } // end of while loop

    } // end of main method

    /**
     * Loads fleet data from a CSV file.
     * The file should contain boat details in CSV format. Each line represents one boat.
     *
     * @param fileName The name of the CSV file to load.
     */
    private static void loadCSV(String fileName) {

        fileName = "/CSC120/PROJECT2/src/fleet/FleetData.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                addBoatFromCSV(line);

            }

        } catch (IOException e) {

            System.out.println("CANT READ FILE");

        } // end of try-catch

    } // end of loadCSV method

    /**
     * Loads fleet data from a serialized file.
     * If the file is not found or cannot be read, initializes an empty fleet.
     */
    private static void loadSerializedFile() {

        File file = new File("FleetData.db");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            fleetManager = (FleetManager) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {

            fleetManager = new FleetManager();

        } // end of try-catch

    } // end of loadSerializedFile method

    /**
     * Saves the current fleet data to a serialized file.
     * This method ensures fleet data is persisted for future use.
     */
    private static void saveToSerializedFile() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FleetData.db"))) {

            oos.writeObject(fleetManager);

        } catch (IOException _) {

        } // end of try-catch

    } // end of saveToSerializedFile method

    /**
     * Adds a boat to the fleet from a CSV string.
     * The string should contain boat details in the following format:
     * "type,name,yearOfManufacture,makeModel,length,purchasePrice"
     *
     * @param csvData A CSV string representing the boat's details.
     */
    private static void addBoatFromCSV(String csvData) {

        try {

            BoatType type;
            String name;
            short manufactureYear;
            String makeModel;
            byte length;
            double purchasePrice;

            String[] parts = csvData.split(",");

            type = BoatType.valueOf(parts[0].trim().toUpperCase());
            name = parts[1].trim();
            manufactureYear = Short.parseShort(parts[2].trim());
            makeModel = parts[3].trim();
            length = Byte.parseByte(parts[4].trim());
            purchasePrice = Double.parseDouble(parts[5].trim());

            Boat newBoat = new Boat(type, name, manufactureYear, makeModel, length, purchasePrice);
            fleetManager.addBoat(newBoat);

        } catch (Exception _) {

        } // end of try-catch

    } // end of addBoatFromCSV method

} // end of Main class