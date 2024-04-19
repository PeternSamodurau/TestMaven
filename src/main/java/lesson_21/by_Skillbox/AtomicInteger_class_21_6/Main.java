package lesson_21.by_Skillbox.AtomicInteger_class_21_6;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++){

            new Thread(()->{

                for (int j = 0; j < 1000; j++){

                    MyClass.incrementValue();

                }

                System.out.println(MyClass.getValue());

            }).start();
        }
    }
}
