package org.example.plainJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public Connection getConnection() {
       try{
           Class.forName("org.h2.Driver");
              Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
              connection.setAutoCommit(true);
              return connection;
       }catch(ClassNotFoundException | SQLException e){
           e.printStackTrace();
           throw new RuntimeException("Error connecting to the database", e);
       }
//       return null;
    }


}
