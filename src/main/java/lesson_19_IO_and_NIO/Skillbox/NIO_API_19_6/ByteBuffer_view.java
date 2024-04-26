package lesson_19_IO_and_NIO.Skillbox.NIO_API_19_6;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ByteBuffer_view {
    public static void main(String[] args) throws Exception{
          //ByteBuffer view — способ создания представления (view) данных в ByteBuffer в другой форме (тип данных)
          // или с другой интерпретацией (только чтение, копия, остаток).
          //Это позволяет использовать одни и те же данные в разных контекстах, не создавая новые объекты,
          // и копировать данные между существующими объектами, что помогает ускорить работу и снизить использование памяти.

        ByteBuffer buff = ByteBuffer.allocate(16);    // mark = -1, position = 0, limit = 16, capacity = 16

        buff.put("He".getBytes()); // mark = -1, position = 2, limit = 16, capacity = 16
        buff.mark(); // mark = 2, position = 2, limit = 16, capacity = 16
        buff.put("llo".getBytes()); // mark = 2, position = 5, limit = 16, capacity = 16
        //limit — индекс, до которого производится чтение или запись данных (по умолчанию равен capacity);
        buff.limit(8); // mark = 2, position = 5, limit = 8, capacity = 16

        String result = new String(buff.array(), StandardCharsets.UTF_8);  // пореводим массив байт
        System.out.println(result); // Hello

        //Метод duplicate() создаст новый экземпляр ByteBuffer, который будет ссылаться на ту же область памяти,
        // но иметь свои индексы, скопированные с родительского экземпляра.
        // Изменения данных будут отражаться сразу в двух экземплярах.

        ByteBuffer duplicateView = buff.duplicate();// mark = 2, position = 5, limit = 8, capacity = 16
        duplicateView.position(0);// mark = 2, position = 0, limit = 8, capacity = 16
        duplicateView.put("Good day".getBytes());// mark = 2, position = 8, limit = 8, capacity = 16
        System.out.println(new String(buff.array(), StandardCharsets.UTF_8));// Good day

        duplicateView.limit(16).put(" fellow".getBytes());// mark = 2, position = 15, limit = 16, capacity = 16
        duplicateView.position(9).limit(15);// mark = 2, position = 9, limit = 15, capacity = 16

        //Метод slice() создаст новый экземпляр ByteBuffer начиная с позиции, указанной в родительском экземпляре,
        // сбросит индексы mark и position, а также установит limit и capacity равными размеру нового буфера.

        ByteBuffer slicedView = duplicateView.slice();              // mark = -1, position = 0, limit = 7, capacity = 7
        byte [] slicedByteArr = new byte[slicedView.capacity()];   // создаём массив байт размером с ёмкостью slicedView
        slicedView.get(slicedByteArr);                             // передаём данные начиная с позиции 0
        System.out.println(new String(slicedByteArr, StandardCharsets.UTF_8)); // fellow
    }
}
