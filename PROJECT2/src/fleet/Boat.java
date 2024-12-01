package fleet;

import java.io.Serializable;

/**
 * Represents a boat in the fleet.
 */
public class Boat implements Serializable {
    private BoatType type;
    private String name;
    private int yearOfManufacture;
    private String makeModel;
    private double length;
    private double purchasePrice;
    private double expenses;

    /**
     * Constructs a new Boat.
     *
     * @param type              the type of the boat (SAILING or POWER)
     * @param name              the name of the boat
     * @param yearOfManufacture the year the boat was manufactured
     * @param makeModel         the make and model of the boat
     * @param length            the length of the boat in feet
     * @param purchasePrice     the purchase price of the boat
     */
    public Boat(BoatType type, String name, int yearOfManufacture, String makeModel,
                double length, double purchasePrice) {
        this.type = type;
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.makeModel = makeModel;
        this.length = length;
        this.purchasePrice = purchasePrice;
        this.expenses = expenses;
    }

    // Getters and setters
    public BoatType getType() {
        return type;
    }

    public void setType(BoatType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    /**
     * Returns a formatted string representation of the boat.
     */
    @Override
    public String toString() {
        return String.format("%-8s %-20s %-4d %-10s %5.0f' : Paid $%10.2f : Spent $%10.2f",
                type, name, yearOfManufacture, makeModel, length, purchasePrice, expenses);
    }
}
