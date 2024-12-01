 import java.util.Scanner;

public class Diamond {

    private int carat;
    private double value;

    public Diamond () {

        carat = 0;
        value = 0.0;

    } // end of default contructor

    public Diamond (int carat, double value){

        this.carat = carat;
        this.value = value;

    } // end of Diamond constructor

    public double getCarat(){

        return carat;

    }

    public double getValue(){

        return value;

    } // end of getValue method

    public String toString(){

        return (carat + " carats, worth $" + value);

    } // end of toString method

} // end of Diamond Class


class Girl {

    private String name;
    private Diamond diamond;

    public Girl (String name) {

        this.name = name;
        this.diamond = null;

    } // end of default constructor

    public boolean chooseDiamond(Diamond newDiamond) {

        if (diamond == null || newDiamond.getValue() > diamond.getValue()) {

            diamond = newDiamond;
            return true;

        } else {

           return false;

        } // end of if-else statement

    } //end of chooseDiamond method

    public String toString() {

        if (diamond != null) {

            return (name + " has a diamond, " + diamond + ".");

        } else {

            return name + " has no best friend";

        }

    }

} //end of Girl class


class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the girl : ");
        String girlName = scanner.nextLine();
        Girl girl = new Girl(girlName);



        while(true){

            System.out.println(girl);

            System.out.println("Enter carats and value     : ");
            int carats = scanner.nextInt();
            double price = scanner.nextDouble();

            if (carats == 0) {
                break;

            }

            Diamond newDiamond = new Diamond(carats, price);

            if(girl.chooseDiamond(newDiamond)){

                System.out.println("Woohoo, the girl took the diamond");

            } else {
                System.out.println("Aaargh, the diamond was rejected ");
            }

        }

        System.out.println(girl);

        scanner.close();

    }


} // end of main