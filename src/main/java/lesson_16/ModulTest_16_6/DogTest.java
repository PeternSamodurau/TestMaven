package lesson_16.ModulTest_16_6;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DogTest {
    static Dog dog;                                              // создали переменную класса

    @BeforeEach                                          // анатация запускающая нечто перед каждым тестом
     void createDog(){
         dog = new Dog("Albert", 20);
    }


    @org.junit.jupiter.api.Test
    void testGetDogName() {                            //тесты со слова тест
       // Dog dog = new Dog("Albert", 20);              // перенесли в анотацию @BeforeEach
        assertEquals("Albert", dog.getName()); // если не Albert то тест не сработает
    }

    @Test                                                // можно так аннатацию написать
    void testSetDogName() {
       // Dog dog = new Dog("Albert", 20);          // был Albert
        dog.setName("Roman");                       // стал Roman
        // assertEquals("Roman",dog.getName()); // тест пройден
        assertEquals("Albert", dog.getName());     // модифицируем ожидание под if() в классе Dog
    }

    @org.junit.jupiter.api.Test
    void testSetDogNameIfEmpty() {
        Dog dog = new Dog("", 20);  // если имени не было
        dog.setName("Roman");                  // называем Roman
        assertEquals("Roman", dog.getName());
    }

    @org.junit.jupiter.api.Test
    void getAge() {
    }

    @org.junit.jupiter.api.Test
    void setAge() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}