import java.util.Scanner;

public class KillingKangaroos {
    private static Scanner keyboard = new Scanner(System.in);
    private static final double KANGAROO_KILL_PROBABILITY = 1.47;
    private static final double ROAD_WIDTH = 0.01;

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        double sideLength;
        double roadLength;
        int kangarooNumber;
        double rooDensity;
        double roadSurfaceArea;
        double kills;

        System.out.println("Enter side of square in km  : ");
        sideLength = scnr.nextDouble();

        System.out.println("Enter roads length in km    : ");
        roadLength = scnr.nextDouble();

        System.out.println("Enter number of 'roos       : ");
        kangarooNumber = scnr.nextInt();

        rooDensity = kangarooNumber/(sideLength * sideLength);
        roadSurfaceArea = roadLength * ROAD_WIDTH;
        kills = rooDensity * roadSurfaceArea * KANGAROO_KILL_PROBABILITY;

        System.out.println("Expected number of kills is : " + (int)kills);

        if (kills == (int)kills) {
             System.out.println("Expected number of injuries : 0");
        }
        else {
             System.out.println("Expected number of injuries : 1");
        }
    }
}
