package lesson_19_IO_and_NIO.Skillbox.URLrider;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.youtube.com/watch?v=KxsFlX1SB3w");
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()){
            String line = scanner.next();
            System.out.print(line);
        }
        scanner.close();

    }
}
