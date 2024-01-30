package Lesson_17.match;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //.anyMatch(); возващает true если найден хотябы один элемент по условию
        boolean hasMoreThen10 = Stream.of(1, 2, 5, 9)
                .anyMatch(i -> i > 10);    // false
        System.out.println(hasMoreThen10);

//.noneMatch(); возвращает true, если все НЕ соответствуют условию
        boolean allMoreThen10 = Stream.of(1, 2, 6, 7)
                .noneMatch(i -> i > 10);   // true
        System.out.println(allMoreThen10);
//.allMatch(); возвращает true, если все  соответствуют условию
        boolean allLessThen10 = Stream.of(1, 2, 6, 7)
                .allMatch(i -> i > 10);   // false
        System.out.println(allLessThen10);
    }
}
