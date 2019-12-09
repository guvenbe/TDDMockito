package com.guven.bora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseTest {
    protected static void addTable(Connection connection) throws SQLException {
        final Statement statement = connection.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS USERS"
                + "(id Integer AUTO_INCREMENT, "
                + "firstname VARCHAR(50), "
                + "lastname VARCHAR(50), "
                + "age Integer, "
                + "PRIMARY KEY (id))";

        statement.executeUpdate(sql);
    }

    protected static void insertData(Connection connection) throws SQLException {
        final Statement statement = connection.createStatement();

        String sql = "INSERT INTO USERS"
                + "(firstname, lastname, age) "
                + "values "
                + "('Bora', 'Guven', 53), "
                + "('Brittney', 'Yuille', 43), "
                + "('Leyla', 'Guven', 9), "
                + "('Dilara', 'Guven', 6), "
                + "('Andrew', 'Brown', 55), "
                + "('Andrew', 'Smith', 31), "
                + "('Bob', 'Collins', 25), "
                + "('Mike', 'Mann', 67), "
                + "('Sarah', 'Smith', 29), "
                + "('Eric', 'Briggs', 72), "
                + "('Claire', 'Davies', 42), "
                + "('Mike', 'Mann', 67), "
                + "('Sue', 'Brigs', 68) ";

        statement.executeUpdate(sql);
    }

    protected static Connection getH2Connection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test");
    }

    //Docker mysql database database
    protected static Connection getMYSQLConnection() throws SQLException {
        return  DriverManager.getConnection("jdbc:mysql://root:****001@localhost:3307/sfg_dev");
    }

    protected static void dropTable(Connection connection) throws SQLException {
        final Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE USERS");
    }
}
