package lesson_16.jenerics_16_2.subtyping;

public class Main {
    public static void main(String[] args) {
      // SomeClass<String> someClass = new SomeClass<String>();   // так написать не можем - стринг не намбер
        SomeClass<Integer> someClass = new SomeClass<>(12);         // а так можем
        SomeClass<Double> someClass1 = new SomeClass<>(12.36);          // и так можем
        System.out.println(someClass.getValue() + someClass1.getValue());

    }
}
