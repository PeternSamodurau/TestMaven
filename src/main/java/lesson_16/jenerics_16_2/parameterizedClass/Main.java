package lesson_16.jenerics_16_2.parameterizedClass;

public class Main {

    //создаем класс, но не знаем пока какое значение н будет содержать

    public static void main(String[] args) {

        SomeClass<String> someClass = new SomeClass<>("Privet");     //теперь можно использовать конкретный тип
        System.out.println(someClass);
        String s = someClass.getValue();
        System.out.println(s);

        SomeClass<Integer> someClass1 = new SomeClass<>(4654);
        System.out.println(someClass1);
        Integer i = someClass1.getValue();
        System.out.println(i);
        System.out.println("-------------------------------------------");

        SomeClass1<String, Integer> stringIntegerSomeClass1 = new SomeClass1<>("Privet", 546644);
        System.out.println(stringIntegerSomeClass1);

        SomeClass1<Integer, Double> stringIntegerSomeClass2 = new SomeClass1<>(4646, 546644.25);
        System.out.println(stringIntegerSomeClass2.getValue1()+stringIntegerSomeClass2.getValue2());

        System.out.println("-------------------------------------------");

       SomeClass2<Integer> someClass2 = new SomeClass2<>(4654,545);        //пишется один параметр, подразумеваем два
        System.out.println(someClass2.getValue1()+someClass2.getValue2());
    }
}
