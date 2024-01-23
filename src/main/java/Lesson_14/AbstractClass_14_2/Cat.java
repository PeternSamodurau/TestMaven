package Lesson_14.AbstractClass_14_2;

public class Cat extends Animal implements AbleToCanRun {
    public void makeSound() {
        System.out.println("I am cat, i say - meow");
    }

    @Override
    public void canSleep() {
        System.out.println("I am cat, i am - sleeping");
    }

    @Override
    public void canRun() {
        System.out.println("I am cat, i am running");
    }
}
