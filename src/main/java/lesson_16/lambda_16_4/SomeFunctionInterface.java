package lesson_16.lambda_16_4;
@FunctionalInterface
public interface SomeFunctionInterface {
    boolean doSomeThing(Student s, int i);                  // в функц интерф может быть 1 абстрактный метод

    default void show() {
        System.out.println("Hello, this is default method");
    }
    static void someThing(){
        System.out.println("Hello, this is static method");
    }
}
