public class MidtermTest {

    int userValue1, userValue2;
    char choice;
    int result;
    userValue1 = keyboard.nextInt();
    userValue2 = keyboard.nextInt();
    choice = keyboard.nextLine().charAt(0);

   if (choice == 'A') {

        result = userValue1;

    } else if (choice == 'B') {

       result = userValue2;

    } else {
       result = (int) choice;
    }


}
