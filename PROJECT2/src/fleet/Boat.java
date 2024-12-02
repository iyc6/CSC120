package fleet;

import java.io.Serializable;

/**
 * Represents a boat in the fleet.
 */
public class Boat implements Serializable {
    private BoatType type;
    private String name;
    private short manufactureYear;
    private String makeModel;
    private byte length;
    private double purchasePrice;
    private double expenses;

    /**
     * Constructs a new Boat.
     *
     * @param type              the type of the boat (SAILING or POWER)
     * @param name              the name of the boat
     * @param manufactureYear the year the boat was manufactured
     * @param makeModel         the make and model of the boat
     * @param length            the length of the boat in feet
     * @param purchasePrice     the purchase price of the boat
     */
    public Boat(BoatType type, String name, short manufactureYear, String makeModel, byte length, double purchasePrice) {

        this.type = type;
        this.name = name;
        this.manufactureYear = manufactureYear;
        this.makeModel = makeModel;
        this.length = length;
        this.purchasePrice = purchasePrice;
        this.expenses = expenses;

    } // end of Boat method

    public BoatType getType() {

        return type;

    } // end of getType method


    public String getName() {

        return name;

    } // end of getName method


    public int getManufactureYear() {

        return manufactureYear;

    } // end of getManufactureYear method


    public String getMakeModel() {

        return makeModel;

    } // end of getMakeModel method

    public double getLength() {

        return length;

    } // end of getLength method


    public double getPurchasePrice() {

        return purchasePrice;

    } // end of getPurchasePrice method


    public double getExpenses() {

        return expenses;

    } // end of getExpenses method

    public void setExpenses(double expenses) {

        this.expenses = expenses;

    } // end of setExpenses method

    /**
     * Returns a formatted string representation of the boat.
     */
    @Override
    public String toString() {

        return String.format("%-8s %-20s %-4d %-10s %5.0f' : Paid $%10.2f : Spent $%10.2f",

                type, name, manufactureYear, makeModel, length, purchasePrice, expenses);

    } // end of toString method

} // end of Boat class
