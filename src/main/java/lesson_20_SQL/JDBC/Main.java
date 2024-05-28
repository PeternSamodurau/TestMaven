package lesson_20_SQL.JDBC;

// Java Data Base Connection  - интерфейс, взаимодействие бд осуществляется с помощью драйверов, которые облегчают взаимодействие с бд

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox?serverTimezone=UTC";
        String user = "root";
        String pass = "Jiffbuh1";

        try {
            Connection connection = DriverManager.getConnection(url,user, pass);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses");

            while (resultSet.next()){
                String courseName = resultSet.getString("name");
                System.out.println(courseName);
            }
            resultSet.close();
            statement.close();
            connection.close();


        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }

}
