package A2_Практика.Другое;

public class Main {

    private static int n = 4;

    public static void main(String[] args) {

       sum(n);

    }

    public static void sum(int n) {

        if (n == 0) return;

        System.out.println(n + " ");

        sum(n - 1);

    }

}
