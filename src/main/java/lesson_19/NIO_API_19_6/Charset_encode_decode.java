package lesson_19.NIO_API_19_6;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Charset_encode_decode {
    //Класс Charset — это инструмент сопоставления последовательности байтов с конкретной кодировкой текста,
    // определённой в стандартах IANA (Internet Assigned Numbers Authority).
    // Его можно использовать для кодирования текста в байтовые последовательности и декодирования.
    // Некоторые кодировки, которые можно использовать с помощью класса Charset, включают UTF-8, ISO-8859-1 и Windows-1251.
    public static void main(String[] args) {

        //КОДИРУЕМ СТРОКУ в UTF-8
        String text = "Hello Skillbox";
        Charset winCharset = Charset.forName("UTF-8");
        ByteBuffer byteBuffer = winCharset.encode(text);

        // ДЕКОДИРУЕМ из байтовой последовательности в строку
        CharBuffer charBuffer = winCharset.decode(byteBuffer);
        String textFromChar = charBuffer.toString();
        System.out.println(textFromChar);// Hello Skillbox
    }
}
