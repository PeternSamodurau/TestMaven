package lesson_16.jenerics_16_2.parameterizedMethod;

import java.util.List;

public class SomeClass {
    public static <T> T getSecondElement(List<T> list){           //d в параметр передается List какого-то типа <T>

        return list.get(1);                                        // возвращае 2-й элемент
    }
}
