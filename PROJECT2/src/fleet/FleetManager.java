package fleet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Manages the adding, removing, and managing expenses for the fleet.
 */
public class FleetManager implements Serializable {

    private ArrayList<Boat> fleet;

    /**
     * Constructs a FleetManager with an empty fleet.
     */
    public FleetManager() {

        this.fleet = new ArrayList<>();

    } // end of FleetManager method

    /**
     * Adds a boat to the fleet.
     *
     * @param boat the boat to add
     */
    public void addBoat(Boat boat) {

        fleet.add(boat);

    } // end of addBoat method

    /**
     * Removes a boat from the fleet by its name (case-insensitive).
     *
     * @param name the name of the boat to remove
     * @return true if the boat was found and removed, false otherwise
     */
    public boolean removeBoat(String name) {
        for (int index = 0; index < fleet.size(); index++) {

            if (fleet.get(index).getName().equalsIgnoreCase(name)) {

                fleet.remove(index);
                return true;

            } // end of if loop

        } // end of for loop

        return false;

    } // end of removeBoat boolean

    /**
     * Authorizes an expense for a specific boat, if within budget.
     *
     * @param name   the name of the boat (case-insensitive)
     * @param amount the amount to spend
     * @return true if the expense is authorized, false otherwise
     */
    public boolean authorizeExpense(String name, double amount) {

        for (Boat boat : fleet) {

            if (boat.getName().equalsIgnoreCase(name)) {

                double remainingBudget = boat.getPurchasePrice() - boat.getExpenses();

                if (amount <= remainingBudget) {

                    boat.setExpenses(boat.getExpenses() + amount);
                    return true;

                } // end of if loop

                return false;

            } // end of if loop

        } // end of for loop

        return false; // Boat not found

    } // end of authorizeExpense boolean

    /**
     * Prints a formatted report of the fleet.
     * Displays information about each boat, including type, name, year of manufacture,
     * make/model, length, purchase price, and expenses.
     * Also shows the total purchase price and expenses for the entire fleet.
     */
    public void printFleet() {

        double totalPaid = 0;
        double totalSpent = 0;

        System.out.println("\nFleet report:");

        for (Boat boat : fleet) {

            System.out.printf("    %-8s %-20s %-4d %-10s %5.0f' : Paid $ %9.2f : Spent $ %9.2f%n",

                    boat.getType(),
                    boat.getName(),
                    boat.getManufactureYear(),
                    boat.getMakeModel(),
                    boat.getLength(),
                    boat.getPurchasePrice(),
                    boat.getExpenses()

            );

            totalPaid += boat.getPurchasePrice();
            totalSpent += boat.getExpenses();

        } // end of for loop

        System.out.printf("    %-50s : Paid $ %9.2f : Spent $ %9.2f%n", "Total", totalPaid, totalSpent);

    } // end of printFleet method

    /**
     * Finds a boat in the fleet by its name (case-insensitive).
     *
     * @param name the name of the boat to find
     * @return the Boat object if found, or null if not found
     */
    public Boat findBoatByName(String name) {

        return fleet.stream()

                .filter(boat -> boat.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

    } // end of findBoatByName method

} // end of FleetManager class
