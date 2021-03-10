package org.example.boardProject.component;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConnectionMakerImpl implements ConnectionMaker{
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/Board?user=root","root","anstnfla25"
        );
    }
}
