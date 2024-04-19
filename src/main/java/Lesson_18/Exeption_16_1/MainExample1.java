package Lesson_18.Exeption_16_1;

import java.io.IOException;

public class MainExample1 {
    public static void main(String[] args) {

        try {
        System.out.println("B");           // в любом случае печатается
            throw new IOException();       // здесь явно сгенерированно исключение throw new IOException(); поэтому управление точно !!! передается на ближайший блок catch
        } catch (IOException e) {
            System.out.println("C");       // поэтому С будет напечатано
        } catch (Exception e) {
            System.out.println("D");       // не печатается, читай ниже
        } finally {
            System.out.println("E");        // в любом случае печатается
        }

    }
}
//System.out.println("D"); не печатается, потому что это находится в блоке catch, который обрабатывает исключения типа Exception.
// Однако, в вашем коде генерируется исключение IOException, которое является подклассом Exception.
//
//Когда генерируется исключение IOException, Java Virtual Machine (JVM) начинает искать подходящий блок catch для обработки этого исключения.
// В вашем случае, первый блок catch, который может обработать IOException, находится прямо перед блоком catch (Exception e).
// Этот первый блок catch обрабатывает исключение и выводит “C”.
// После обработки исключения, выполнение программы продолжается после блока catch, который обработал исключение.
// Поэтому блок catch (Exception e) не выполняется, и “D” не печатается.
//
//Если бы вы хотели, чтобы “D” было напечатано, вам нужно было бы генерировать исключение, которое не обрабатывается первым блоком catch. Например, вы могли бы генерировать RuntimeException вместо IOException. Тогда это исключение было бы обработано блоком catch (Exception e), и “D” было бы напечатано.