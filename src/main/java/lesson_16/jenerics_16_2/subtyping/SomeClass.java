package lesson_16.jenerics_16_2.subtyping;

import java.util.List;

public class SomeClass<T extends Number> {        // так можно ограничивать классы которые будут подходить по тип Т
    public T value;

    public SomeClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static <T extends Number> T getSecondElement(List<T> list){   // так пишут для метода
        return list.get(0);
    }
}
class SomeClassInt<T extends Number & I1 & I2> {        // запись когда надо использовать интерфейсы

}

interface I1{}
interface I2{}
