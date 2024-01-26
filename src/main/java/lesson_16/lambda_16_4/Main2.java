package lesson_16.lambda_16_4;

public class Main2 {
    public static int i = 10;
    private final static String SOMETHING = "!!!!!!!";

    public static void main(String[] args) {
        def(s -> s.length() + i);
        //или так
        def(String::length);
    }
    static void def(DoSomething someInterface){
        System.out.println(someInterface.abc(DoSomething.doSomeTHing()) + SOMETHING);
    }
}

@FunctionalInterface
interface DoSomething{
    int abc(String s);

    static String doSomeTHing(){
        return "Hello World!!";
    }
}
