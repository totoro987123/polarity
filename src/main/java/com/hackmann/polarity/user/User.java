package com.hackmann.polarity.user;

import com.hackmann.polarity.websocket.Connection;
import org.springframework.stereotype.Component;

public class User {

    private Connection connection;

    public User(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }
    public void disconnect() {
        this.connection.close();
    }

    public void sayHi() {
        System.out.println("Hello, world!");
    }
}
