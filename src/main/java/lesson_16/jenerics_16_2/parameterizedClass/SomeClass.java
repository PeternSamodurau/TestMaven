package lesson_16.jenerics_16_2.parameterizedClass;

public class SomeClass <T> {             // T -хранитель, заполнитель типа который будет заменен на конкретный тип данных

    private  T value;                    // переменныя не может быть static, т к static для всех объектов , а у нас разные типы

    public SomeClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "value=" + value +
                '}';
    }
}
