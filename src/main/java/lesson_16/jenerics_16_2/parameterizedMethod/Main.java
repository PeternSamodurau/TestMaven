package lesson_16.jenerics_16_2.parameterizedMethod;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Peter","Alla","Sveta");
        String s = SomeClass.getSecondElement(stringList);
        System.out.println(s);
        System.out.println("__________________________________");
        stringList.forEach(System.out::println);


        List<Integer> integerList = Arrays.asList(12,454,454,54);
        int sum = integerList.stream().mapToInt(i -> i).sum();
        System.out.println(sum);
    }
}
