package lesson_16.jenerics_16_2.parameterizedClass;

public class SomeClass2<V> {
    //параметрезитованный класс с двумя одинаковыми типами переменных, можно написать так
    private V value1;
    private V value2;

    public SomeClass2(V value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V getValue1() {
        return value1;
    }

    public void setValue1(V value1) {
        this.value1 = value1;
    }

    public V getValue2() {
        return value2;
    }

    public void setValue2(V value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "SomeClass2{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}


