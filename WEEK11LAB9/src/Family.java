public class Family {

    private Person[] members;
    private int numPeople;
    private int totalAge;

    public Family() {
        members = new Person[10];

        numPeople = 0;

        totalAge = 0;
    } // end of Family

    public boolean addPerson(String name, int age) {

        if (numPeople < 10) {

            Person person = new Person(name, age);
            members[numPeople] = person;

            numPeople++;
            totalAge += age;

            return true;

        } else {

            return false;

        }
    } //end of addPerson

    public void birthday(String name) {

        for (int i = 0; i < numPeople; i++) {

            if (members[i].getName().equalsIgnoreCase(name)) {

                members[i].incrementAge();
                totalAge++;

                break;

            }
        }
    }

    public int getNumberOfPeople() {

        return numPeople;

    } // end of getNumberOfPeople method

    public int getTotalAge() {

        return totalAge;

    } // end of getTotalAge method

    public void display() {

        System.out.println("There are " + numPeople + " people in the family, with a total age of " + totalAge);

        for (int i = 0; i < numPeople; i++) {

            System.out.println(members[i].toString());

        }
    }
}
