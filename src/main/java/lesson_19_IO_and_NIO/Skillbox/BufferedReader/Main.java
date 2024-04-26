package lesson_19_IO_and_NIO.Skillbox.BufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        //ЧТЕНИЕ ИЗ ФАЙЛА

        BufferedReader br = new BufferedReader(new FileReader("/Users/АВС/IdeaProjects/Data/info.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        for (; ; ) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            stringBuilder.append(line + "\n");
        }
        br.close();                                            // не забываем закрвать поток!!!
        System.out.println(stringBuilder.toString());

        //ЧТЕНИЕ ИЗ КОНСОЛИ

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // in - стаическая переменная класса System привязана к клавиатуре
        // System.in - бесконечный поток байт на носителе - в голове.....
        while (true){
            String s = bufferedReader.readLine();
            System.out.println(s);               // получаем стринг из байт
        }
    }
}
