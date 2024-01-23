package Lesson_14.Interface_14_3;

public class Person implements AbleToSleep, Comparable{
    private String firstName;
    private String secondName;

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public void canSleep() {
        System.out.println("I can sleep");
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        int firstName = this.secondName.compareTo(person.secondName);
        if (firstName != 0){
            return firstName;
        } else
        return this.firstName.compareTo(person.firstName);
    }
}
