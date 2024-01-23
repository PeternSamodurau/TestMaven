package lesson_16.ModulTest_16_6;

import Lesson_18.ModulTest_16_6.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;


class CarTest {
    Car car;
    @BeforeEach                                // запускается перед каждым тестом
    @Execution(ExecutionMode.CONCURRENT)        //запускается в параллельном потоке
    public void createCar(){
        car = new Car("Skoda","ABC-1234",2019,"Alla");
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)                        //запускается в параллельном потоке
    void getName() {
        assertEquals("Skoda", car.getName());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void getNumber() {
        assertEquals("ABC-1234",car.getNumber());
    }
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void setNumber(){
        car.setNumber("ABCDE-1651");
        assertEquals("ABCDE-1651",car.getNumber());
    }
    @ParameterizedTest                     // тесты для методов с пераметрами
    @Execution(ExecutionMode.CONCURRENT)
    @ValueSource(strings = {"ABC-123","DEF-456","DFG-434"})   //
    @NullSource                             // тест на null
    @EmptySource                             // тест на пустоту
    void testSetNumberMultipleValues(String number){
        car.setNumber(number);
        assertEquals(number,car.getNumber());
    }
    @ParameterizedTest                     // тесты для методов с  ДВУМЯ пераметрами
    @Execution(ExecutionMode.CONCURRENT)
    @CsvSource({"'ABC-123', 'ABC-123'",
            "'DEF-456','DEF-456'"})
    void testSetNumberMultipleValuesTwo(String number,String x){
        car.setNumber(number);
        assertEquals(x,car.getNumber());
    }
    @ParameterizedTest
    @Execution(ExecutionMode.CONCURRENT)
    @CsvSource ({"1,5", "8,12", "32,36"})
    void testSomethingInt(int input, int output ){
        assertEquals(car.somethingInt(input),output);
    }
    @ParameterizedTest
    @Execution(ExecutionMode.CONCURRENT)
    @DisplayName("Test from file - будет выводиться!!!!")    // будет выводиться в заголовке теста
    @CsvFileSource(resources = "/Lesson_18/ModulTest_16_6/test-data.csv",delimiter = '|',numLinesToSkip = 1) // см test-data.csv
    void testSetNumberMultipleValuesTwo1(String input,String expected){
        car.setNumber(input);
        assertEquals(expected,car.getNumber());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    @EnabledOnOs(OS.WINDOWS)             // будет запускаться только на Windows
   // @EnabledOnJre(JRE.JAVA_18)            // будет запускаться только на java 18
    void getYear() {
    assertEquals(2019,car.getYear());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    @DisabledOnOs(OS.LINUX)               // не будет запускаться на Linux
   // @DisabledOnJre(JRE.JAVA_18)          // не будет запускаться только на java 18
    void getOwner() {
        assertEquals("Alla",car.getOwner());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void setOwner() {
        car.setOwner("Peter");
        assertEquals("Peter",car.getOwner());
    }
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void getListOwners(){
        assertArrayEquals(new String[]{"Alla"},car.getOwners().toArray());
    }
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void getListTwoOwners(){
       car.setOwner("Peter");
       assertArrayEquals(new String[]{"Alla","Peter"},car.getOwners().toArray());
    }
    //ТЕСТИРУЕМ ПРИВАТНЫЕ МЕТОДЫ
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void testPrivateMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException { // тестируем private метод PrivateMethod() из Car
        Method method = Car.class.getDeclaredMethod("privateMethod",null); //чтобы достучаться до метода
        method.setAccessible(true);  //запускаем метод
        assertEquals("abc",method.invoke(car).toString());
    }
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void testPrivateMethodWithArgument() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException { // тестируем private метод PrivateMethod() из Car
        Method method = Car.class.getDeclaredMethod("privateMethod",String.class); //чтобы достучаться до метода, указываем тип аргумента
        method.setAccessible(true);  //запускаем метод
        assertEquals("что-то",method.invoke(car,"что-то").toString());
    }
    // тест метода с исключением
    @Test
    void testGetDataFromRemoteServer(){
        Exception exception = assertThrows(Exception.class,()->{
            car.getDataFromRemoteServer();
        });
        assertEquals("error!!!",exception.getMessage());
    }

}