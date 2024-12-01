package fleet;

import java.io.*;
import java.util.Scanner;


public class Main {
    private static FleetManager fleetManager = new FleetManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args.length > 0) {

            loadFromCSV(args[0]);

        } else {

            loadFromSerializedFile();

        }

        while (true) {
            System.out.println("\n(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it : ");
            String choice = scanner.nextLine().trim().toUpperCase();
            switch (choice) {
                case "P":
                    fleetManager.printFleet();
                    break;
                case "A":
                    System.out.println("Please enter the new boat CSV data : ");
                    String csvData = scanner.nextLine();
                    addBoatFromCSV(csvData);
                    break;

                case "R":

                    System.out.println("Which boat do you want to remove? : ");
                    String nameToRemove = scanner.nextLine();

                    if (!fleetManager.removeBoat(nameToRemove)) {

                        System.out.println("Cannot find boat " + nameToRemove);

                    }
                    break;

                case "E":
                    System.out.println("Which boat do you want to spend on? : ");
                    String nameToSpend = scanner.nextLine();

                    Boat targetBoat = fleetManager.findBoatByName(nameToSpend);
                    if (targetBoat == null) {

                        System.out.println("Boat not found.");
                        break;

                    }

                    System.out.println("How much do you want to spend? : ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    if (fleetManager.authorizeExpense(nameToSpend, amount)) {
                        System.out.printf("Expense authorized, $%.2f spent.%n", targetBoat.getExpenses());
                    } else {

                        targetBoat = fleetManager.findBoatByName(nameToSpend);

                        if (targetBoat != null) {

                            double remainingBudget = targetBoat.getPurchasePrice() - targetBoat.getExpenses();
                            System.out.printf("Expense not permitted, only $%.2f left to spend.%n", remainingBudget);

                        }

                    }
                    break;

                case "X":

                    saveToSerializedFile();
                    System.out.println("Exiting the Fleet Management System.");
                    return;

                default:
                    System.out.println("Invalid menu option, try again.");
            }
        }
    }



    private static void loadFromCSV(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Opening file: " + fileName); // Debugging message
            String line;
            while ((line = reader.readLine()) != null) { // Read each line of the CSV file
                System.out.println("Read line: " + line); // Debugging message
                addBoatFromCSV(line); // Parse and add the boat to the fleet
            }
            System.out.println("Fleet data loaded successfully from CSV.");
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    // Load fleet data from serialized file
    private static void loadFromSerializedFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FleetData.db"))) {
            fleetManager = (FleetManager) ois.readObject();
            System.out.println("Fleet data loaded from serialized file.");
        } catch (FileNotFoundException e) {
            System.out.println("Serialized file not found. Starting with an empty fleet.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading serialized data: " + e.getMessage());
        }
    }

    // Save fleet data to serialized file
    private static void saveToSerializedFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FleetData.db"))) {
            oos.writeObject(fleetManager);
            System.out.println("Fleet data saved to serialized file.");
        } catch (IOException e) {
            System.err.println("Error saving fleet data: " + e.getMessage());
        }
    }

    // Parse CSV line and add a boat to the fleet
    private static void addBoatFromCSV(String csvData) {

        try {

            String[] parts = csvData.split(",");

            if (parts.length != 6) {

                System.err.println("Invalid CSV format. Correct format: type,name,year,makeModel,length,purchasePrice,expenses");
                return;

            }

            BoatType type = BoatType.valueOf(parts[0].trim().toUpperCase());
            String name = parts[1].trim();
            int yearOfManufacture = Integer.parseInt(parts[2].trim());
            String makeModel = parts[3].trim();
            double length = Double.parseDouble(parts[4].trim());
            double purchasePrice = Double.parseDouble(parts[5].trim());

            Boat newBoat = new Boat(type, name, yearOfManufacture, makeModel, length, purchasePrice);
            fleetManager.addBoat(newBoat);

        } catch (Exception e) {
            System.err.println("Error adding boat from CSV: " + e.getMessage());
        }
    }
}