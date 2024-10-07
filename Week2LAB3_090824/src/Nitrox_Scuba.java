import java.util.Scanner;

public class Nitrox_Scuba {

    private static final Scanner keyboard = new Scanner(System.in);

    private static final double FEET_PER_ATMOSPHERE = 33.0;
    private static final double MAX_O2_PRESSURE = 1.4;
    private static final double MIN_CONTINGENCY_PRESSURE = 1.6;

    public static void main(String[] args) {

        int diveDepth;
        int percentO2;

        //data input
        System.out.println("Enter depth and percentage O2   : ");
        diveDepth = keyboard.nextInt();
        percentO2 = keyboard.nextInt();

        double ambientPressure = (diveDepth / FEET_PER_ATMOSPHERE) + 1;
        System.out.println("Ambient pressure                : " + ambientPressure);

        double partialPressure = (percentO2 / 100.0) * ambientPressure;
        System.out.println("O2 pressure                     : " + partialPressure);

        char o2Group;
        o2Group = (char)((int)(partialPressure * 10) + (int)'A');
        System.out.println("O2 group                        : " + o2Group);

        if (partialPressure <= MAX_O2_PRESSURE) {
            System.out.println("Exceeds maximal O2 pressure     : false");
        } else {
            System.out.println("Exceeds maximal O2 pressure     : true");
        }

        if (partialPressure <= MIN_CONTINGENCY_PRESSURE) {
            System.out.println("Exceeds contingency O2 pressure : false");
        } else {
            System.out.println("Exceeds contingency O2 pressure : true");
        }

    }
}