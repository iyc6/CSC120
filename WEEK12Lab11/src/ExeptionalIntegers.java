import java.util.ArrayList;

public class ExeptionalIntegers {

    public static void main(String[] args) {

        ArrayList<Integer> integerList = new ArrayList<>();


        for (String arg : args) {
            try {

                Integer number = converter(arg);

                integerList.add(number);
            } catch (NumberFormatException e) {

                System.out.println("Catch block says the argument \"" + arg + "\" is ignored because " + arg);
            }
        }


        System.out.println("\nThe ArrayList contents are:");
        for (int index = 0; index < integerList.size(); index++) {

            System.out.println("Item " + index + " is " + integerList.get(index));

        }
    }


    private static Integer converter(String givenString) throws NumberFormatException {

        int value;

        value= Integer.parseInt(givenString);

        System.out.println("Converter method says integer OK - " + value);

        return Integer.valueOf(value);
    }
}
