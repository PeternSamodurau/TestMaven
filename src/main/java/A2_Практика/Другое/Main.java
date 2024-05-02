package A2_Практика.Другое;

public class Main {
    public static int n = 6;

    public static void main(String[] args) {
        System.out.println("фиб " + fib(n));
    }

    public static long fib(int n) {

        if (n <= 1) {
            return n;

        } else {
            return fib(n-2) + fib(n- 1);
        }
    }
}
