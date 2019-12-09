package com.guven.bora.repositories;

import com.guven.bora.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List <User> getAllUsers() {
        try {
            final Statement statement = this.connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
            final ArrayList <User> users = new ArrayList <>();
            while (resultSet.next()){
                users.add(new User(resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4)));
            }
            return users;
        } catch (SQLException e) {
           throw  new RuntimeException("Error getting users from database");
        }
    }
}
