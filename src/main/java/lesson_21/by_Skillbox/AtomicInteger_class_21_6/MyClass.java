package lesson_21.by_Skillbox.AtomicInteger_class_21_6;

import java.util.concurrent.atomic.AtomicInteger;

public class MyClass {

    private static AtomicInteger value = new AtomicInteger();

    public static void incrementValue() {

        value.incrementAndGet();
    }

    public static int getValue() {

        return value.intValue();
    }
}
