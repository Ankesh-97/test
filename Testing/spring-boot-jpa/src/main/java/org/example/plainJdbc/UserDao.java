package org.example.plainJdbc;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
public class UserDao {

    public void createUserTable(){
        DatabaseConnection databaseConnection = new DatabaseConnection();
         Connection connection = databaseConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(100))");
            boolean val =preparedStatement.execute();
            System.out.println(val);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void insertUser(int id, String name) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        try {
            boolean result = connection.createStatement().execute("INSERT INTO users VALUES (" + id + ",'" + name + "')");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void selectUser(int id) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM users WHERE id = " + id);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
