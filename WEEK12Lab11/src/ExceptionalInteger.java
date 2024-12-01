import java.util.ArrayList;

public class ExceptionalInteger {

    public static void main(String[] args) {

        ArrayList<Integer> integerList = new ArrayList<>();

        for (String arg : args) {
            try {

                Integer number = converter(arg);

                integerList.add(number);

            } catch (NumberFormatException e) {

                System.out.println("Catch block says the argument \"" + arg + "\" is ignored because " + arg);

            } // end of try-catch

        } // end of for loop


        System.out.println("\nThe ArrayList contents are:");
        for (int index = 0; index < integerList.size(); index++) {
            System.out.println("Item " + index + " is " + integerList.get(index));
        } // end of for loop
    } // end of main method


    private static Integer converter(String givenString) throws NumberFormatException {

        int value;

        value = Integer.parseInt(givenString);

        System.out.println("Converter method says integer OK - " + value);

        return Integer.valueOf(value);

    } // end of converter method

} //end of ExceptionalInteger class
