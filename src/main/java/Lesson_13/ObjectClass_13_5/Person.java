package Lesson_13.ObjectClass_13_5;

import java.util.Objects;

public class Person {
    private final String firstName;
    private final String secondName;

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return Objects.equals(firstName, person.firstName) && Objects.equals(secondName, person.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
        //return firstName.length()+ secondName.length();  // собственная реализация но числа короткие
        //return 31 * (firstName.length()* 13 + secondName.length() * 11); // уже лучше
    }
}
