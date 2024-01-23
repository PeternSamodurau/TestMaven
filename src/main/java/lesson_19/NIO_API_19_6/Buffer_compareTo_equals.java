package lesson_19.NIO_API_19_6;

import java.nio.ByteBuffer;

public class Buffer_compareTo_equals {
    public static void main(String[] args) {
        //Сравнение буферов
        //compareTo() и equals().
        //Эти методы производят сравнение, ограничиваясь диапазоном между индексами position и limit.
        //Буферы можно представить таким образом:

        //buffer1          buffer2
      //S ← position         H
      //k                    e
      //i                    l
      //l                    l
      //l                    o
      //b                    S ← position
      //o                    k
      //x ← limit            i
      //                     l
      //                     l
      //                     b
      //                     o
      //                     x ← limit

    // Сравниваться будут байты от S до x в каждом буфере, если position или limit изменится в одном из буферов, equals вернёт false и compateTo не будет равен нулю.

        byte[] bytes1 = "Skillbox".getBytes();
        byte[] bytes2 = "HelloSkillbox".getBytes();

        ByteBuffer buffer1 = ByteBuffer.wrap(bytes1);
        ByteBuffer buffer2 = ByteBuffer.wrap(bytes2);
        buffer2.position(5);
        boolean equal = buffer1.equals(buffer2); // true
        int result = buffer1.compareTo(buffer2); // 0
        System.out.println(equal);
        System.out.println(result);
    }
}
