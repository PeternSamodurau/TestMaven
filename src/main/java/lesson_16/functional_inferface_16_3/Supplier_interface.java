package lesson_16.functional_inferface_16_3;

import lesson_16.lambda_16_4.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

//чтобы не писать свои функциональные интерфейсы, существуют готовые функциональные интерфейсы

//SUPPlIER - поставщик
// T get(); - возвращает объект типа T ничего не принимая
public class Supplier_interface {

    public static void main(String[] args) {
        List<Student> listStudents = createStudent(() -> new Student("Peter", 'm', 55, 5, 9.3)); // 3 одинаковых студентов
        System.out.println(listStudents);
    }

    public static List<Student> createStudent (Supplier<Student> studentSupplier){
        ArrayList<Student> studentList = new ArrayList<>();
        for (int i =0 ; i < 3; i++){
            studentList.add(studentSupplier.get());
        }
        return studentList;
    }
}
