package lesson_15.javadoc_15_8;

//Javadoc — это инструмент для создания документации
//в формате HTML для Java-кода. Он позволяет разработчикам
//генерировать подробные описания классов, методов, полей
//и других элементов программы, используя комментарии,
//написанные на специальном формате

/**
 * чтото пишем о классе Main
 */
public class Main {
    /**
     * чтото пишем о переменной
     *
     */
    private static final int OPERATION_COUNT = 4;


    public static void main(String[] args) {
        System.out.println(OPERATION_COUNT);
        System.out.println(divide(5,3));

    }

    /**
     *Performs division one number by enother
     * @param a First value
     * @param b Second value
     * @return Division result
     * @throws ArithmeticException if on attempt is mode to divide by zero
     */
    public static double divide (double a, double b) throws ArithmeticException{
        if (b == 0){
            throw new ArithmeticException("Division by zero is impossible");
        }
        return a/b;
    }
}
// в терминале
//javadoc -d docs src/main/java/lesson_15/javadoc_15_8/Main.java
//см папку docs, которая генеируется автоматичеси, там файл index.html, открыть в проводнике