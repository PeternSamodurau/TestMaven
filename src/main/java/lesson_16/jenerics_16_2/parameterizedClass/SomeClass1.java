package lesson_16.jenerics_16_2.parameterizedClass;

public class SomeClass1 <V1,V2> {              //параметрезитованный класс с двумя переменными
    private V1 value1;
    private V2 value2;

    public SomeClass1(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getValue1() {
        return value1;
    }

    public void setValue1(V1 value1) {
        this.value1 = value1;
    }

    public V2 getValue2() {
        return value2;
    }

    public void setValue2(V2 value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "SomeClass1{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}
