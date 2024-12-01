public class Person {

    private String name;
    private int age;

    public Person() {

        this.name = "Unknown";
        this.age = 0;

    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;

    } //end of Person

    public String getName() {

        return name;

    } //end of getName

    public int getAge() {

        return age;

    } //end of getAge

    public void incrementAge() {

        age++;

    } //end of incrementAge

    @Override
    public String toString() {

        return name + " is " + age + " years old";

    }// end of toString

} // end of Person class
