//=================================================================================================
public class Practice {
    private static final int NUMBER_OF_ELEMENTS = 6;
    private static final int POWER_EXPONENT = 3;
    public static void main(String[] args) {
        double [] array = new double[NUMBER_OF_ELEMENTS];
        int index;

        for (index = 0; index < NUMBER_OF_ELEMENTS; index++) {

            array[index] = Math.pow(index, POWER_EXPONENT);

        }
    }

}
//=================================================================================================