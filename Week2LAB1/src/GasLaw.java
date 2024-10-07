import java.util.Scanner;
//=============================================================================
public class GasLaw {
    //-----------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    /*----The gas constant in Joules/mole/K */
    private static final double gasConstant = 8.3143;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold system values
        double volume, moles, temperature;
        double pressure;

//----Get data
        System.out.print("Enter volume, moles, temperature : ");
        volume = keyboard.nextDouble();
        moles = keyboard.nextDouble();
        temperature = keyboard.nextDouble();

//----Gass law equation
        pressure = moles * gasConstant * temperature / volume;

//----Result
        System.out.println("Pressure is " + pressure);
    }
//-----------------------------------------------------------------------------
}
//=============================================================================