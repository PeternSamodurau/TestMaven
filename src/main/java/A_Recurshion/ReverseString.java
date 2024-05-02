package A_Recurshion;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(revers(s));
    }

    private static String revers(String s) {
        if (s.length() == 1) return s;
        return "" + s.charAt(s.length()-1) + revers(s.substring(0,s.length()-1));
    }
}
