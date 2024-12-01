package fleet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Manages a fleet of boats.
 */
public class FleetManager implements Serializable {
    private ArrayList<Boat> fleet;

    /**
     * Constructs a FleetManager with an empty fleet.
     */
    public FleetManager() {
        this.fleet = new ArrayList<>();
    }

    /**
     * Adds a boat to the fleet.
     *
     * @param boat the boat to add
     */
    public void addBoat(Boat boat) {
        fleet.add(boat);
    }

    /**
     * Removes a boat from the fleet by its name (case-insensitive).
     *
     * @param name the name of the boat to remove
     * @return true if the boat was found and removed, false otherwise
     */
    public boolean removeBoat(String name) {
        Optional<Boat> boatToRemove = fleet.stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst();

        if (boatToRemove.isPresent()) {
            fleet.remove(boatToRemove.get());
            return true;
        }

        return false;
    }

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
                }
                return false; // Expense exceeds remaining budget
            }
        }
        return false; // Boat not found
    }

    /**
     * Prints a formatted report of the fleet.
     */
    public void printFleet() {
        double totalPaid = 0;
        double totalSpent = 0;

        System.out.println("\nFleet report:");

        // Iterate through each boat and print its details in the desired format
        for (Boat boat : fleet) {
            System.out.printf("    %-8s %-20s %-4d %-10s %5.0f' : Paid $ %9.2f : Spent $ %9.2f%n",
                    boat.getType(),                  // Boat type (POWER/SAILING)
                    boat.getName(),                  // Name of the boat
                    boat.getYearOfManufacture(),     // Year of manufacture
                    boat.getMakeModel(),             // Make/model
                    boat.getLength(),                // Length in feet
                    boat.getPurchasePrice(),         // Purchase price
                    boat.getExpenses()               // Total expenses
            );

            totalPaid += boat.getPurchasePrice();
            totalSpent += boat.getExpenses();
        }

        // Print the total amounts in the desired format
        System.out.printf("    %-50s : Paid $ %9.2f : Spent $ %9.2f%n",
                "Total", totalPaid, totalSpent);
    }

    public Boat findBoatByName(String name) {
        return fleet.stream()
                .filter(boat -> boat.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }


}
