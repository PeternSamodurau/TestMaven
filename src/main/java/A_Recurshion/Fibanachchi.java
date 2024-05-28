package A_Recurshion;

public class Fibanachchi {
    public static int n = 5;

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
